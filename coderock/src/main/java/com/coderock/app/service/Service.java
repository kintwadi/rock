package com.coderock.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coderock.app.dao.Dao;
import com.coderock.app.entities.Topic;

@org.springframework.stereotype.Service
@Transactional
public class Service {
	
	@Autowired
	private Dao dao;
	
	
	public void save(Object object) {
		
		dao.save(object);
	}
	
	public List<Topic> getAllTopics() {
	
		List<Topic> allTopics = dao.getAllTopics();

		return allTopics;
		
	}
	
	
	
	
	
}
