package com.example.day01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void pingSuccess() {
        // Act
        ResponseEntity<PingResponse> result
                = restTemplate.getForEntity("/ping", PingResponse.class);
        // Assert response code == 200
        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertEquals(200, result.getStatusCode().value());
        // Assert message = "pong"
        assertEquals("pong", result.getBody().getMessage());
    }

}