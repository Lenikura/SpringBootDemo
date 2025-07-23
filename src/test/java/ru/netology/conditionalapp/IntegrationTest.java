package ru.netology.conditionalapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IntegrationTest {

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void testDevProfile() {
        String url = "http://localhost:8080/profile";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals("Current profile is dev", response.getBody());
    }

    @Test
    void testProdProfile() {
        String url = "http://localhost:8081/profile";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals("Current profile is production", response.getBody());
    }
}