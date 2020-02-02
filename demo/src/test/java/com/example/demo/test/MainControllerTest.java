package com.example.demo.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Topic;
import com.example.demo.service.TopicService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

	@LocalServerPort
	private int port;
	 
	private TestRestTemplate restTemplate;
	private TopicService topicService;
	
	@Autowired
	public MainControllerTest(TestRestTemplate restTemplate, TopicService topicService) {
		this.restTemplate = restTemplate;
		this.topicService = topicService;
	}
	
	@Test
    public void getHello() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/hello").toString(), String.class);
        assertEquals("Hello", response.getBody());
    }
	
	@Test
    public void getWelcome() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/").toString(), String.class);
        assertEquals("<h1>Welcome!</h1>", response.getBody());
    }
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(topicService).isNotNull();
	}
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
	    // given
	    Topic topic = new Topic("java", "java name", "java description");
	    topicService.addTopic(topic);
	 
	    // when
	    Topic  t = topicService.getTopic("java");
	 
	    // then
	    assertThat(t.getName())
	      .isEqualTo(topic.getName());
	}

}
