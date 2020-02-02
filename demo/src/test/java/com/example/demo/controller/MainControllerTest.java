package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

	@LocalServerPort
	private int port;
	 
	private TestRestTemplate restTemplate;
	
	@Autowired
	public MainControllerTest(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Test
    public void getHello() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/hello").toString(), String.class);
        assertEquals("Hello", response.getBody());

    }

}
