package com.coderock.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "topic")
@Component
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityReference(alwaysAsId=true)
public  class Topic  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="topicid")
	private int id;
	private String language;
	@Column(name ="topictitle")
	private String title;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "topic")
	private List<SubTopic> subTopics = new ArrayList<SubTopic>();
	
	public Topic() {
		super();
	}
	

	public Topic(String language, String title, List<SubTopic> subTopics) {
		super();
		
		this.language = language;
		this.title = title;
		this.subTopics = subTopics;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<SubTopic> getSubTopics() {
		return subTopics;
	}
	public void setSubTopics(List<SubTopic> subTopics) {
		this.subTopics = subTopics;
	}
	
	@Override
	public String toString() {
		return "Topic [id=" + id + ", language=" + language + ", title=" + title + ", subTopics=" + subTopics + "]";
	}
	
	
	

}
