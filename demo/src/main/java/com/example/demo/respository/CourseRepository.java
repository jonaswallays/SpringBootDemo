package com.example.demo.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Course;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	public List<Course> findByTopicId(String topicId);
}
