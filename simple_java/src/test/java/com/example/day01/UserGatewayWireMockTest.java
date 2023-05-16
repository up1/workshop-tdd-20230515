package com.example.day01;

import com.example.day01.data.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
public class UserGatewayWireMockTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    public void successWithUserId() {
        // Act
        UserResponse result = userGateway.getById(1);
        // Assert
        assertEquals("Leanne Graham", result.getName());
        assertEquals("Sincere@april.biz", result.getEmail());
    }
}