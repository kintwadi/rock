package com.coderock.app.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderock.app.entities.Data;
import com.coderock.app.entities.SubTopic;
import com.coderock.app.entities.Topic;
import com.coderock.app.service.Service;
import com.google.gson.Gson;


@Controller
public class HomeController {
	
	@Autowired
	private Service service;

	@RequestMapping("/")
	
	public String home(Model model) {
		
		Topic topic1 = new Topic("Java", "Web Services with JAX-WS", null);
		Topic topic2 = new Topic("Java", "RESTful Web Services with JAX-RS", null);
		
		SubTopic subTopic1 = new SubTopic("SOAP based web services", "", topic1);
		SubTopic subTopic2 = new SubTopic("REST based web services", "", topic2);
		List<SubTopic> subTopics1 = new ArrayList<SubTopic>();
		subTopics1.add(subTopic1);
		
		List<SubTopic> subTopics2 = new ArrayList<SubTopic>();
		subTopics2.add(subTopic2);
		
		topic1.setSubTopics(subTopics1);
		topic2.setSubTopics(subTopics2);
		
		
		//service.save(topic1); 
		//service.save(topic2);
		//service.save(subTopic1); 
		//service.save(subTopic2);
		model.addAttribute("topics",service.getAllTopics());
		 
		System.out.println("TOPICS..."+ service.getAllTopics().toString());
		
		

		return "home";
	}
	
	@RequestMapping(value = "/topics")
	@ResponseBody
	public String getTopics(){
		
		List<Topic> allTopics = service.getAllTopics();
		System.out.println(allTopics.toString());
		Gson gson = new Gson();
		String json = gson.toJson(allTopics.toString());
		return json;
	}
	
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	@ResponseBody
	public String loadData(@RequestBody Data data) {
		
		System.out.println("aquiii"+ data.toString());
		return "loaded";
	}
}
