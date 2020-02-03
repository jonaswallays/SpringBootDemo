package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Topic;
import com.example.demo.respository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<Topic>();
		//topicRepository.findAll().forEach(t -> topics.add(t));
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		Optional<Topic> optional = topicRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return new Topic("Unknown Topic", "Unknown", "Topic doesn't exist!");
		}
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);		
	}
	
	
	
}
