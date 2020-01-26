package com.example.demo.respository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{
	
}
