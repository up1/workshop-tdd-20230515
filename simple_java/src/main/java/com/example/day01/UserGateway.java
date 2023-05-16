package com.example.day01;

import com.example.day01.data.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {

    @Autowired
    private RestTemplate restTemplate;

    public UserResponse getById(int id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        ResponseEntity<UserResponse> result
                = restTemplate.getForEntity(url, UserResponse.class);
        return result.getBody();
    }

}
