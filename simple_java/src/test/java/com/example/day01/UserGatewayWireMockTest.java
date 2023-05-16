package com.example.day01;

import com.example.day01.data.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
public class UserGatewayWireMockTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    public void successWithUserId() {
        // Arrange
        stubFor(get(urlEqualTo("/users/1")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withStatus(200)
                .withBody("{\"name\": \"Leanne Graham\", \"email\": \"Sincere@april.biz\"}")));

        // Act
        UserResponse result = userGateway.getById(1);
        // Assert
        assertEquals("Leanne Graham", result.getName());
        assertEquals("Sincere@april.biz", result.getEmail());
    }
}