package com.coderock.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coderock.app.entities.Topic;

@Repository
@Transactional
public class Dao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Object object) {
		Session session= null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Integer id =(Integer) session.save(object);
			System.out.println("object is created With Id::"+id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Object object) {
		Session session= null;

		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Topic> getAllTopics() {
	
		Session session= null;
		List <Topic>list = new ArrayList<Topic>();
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			list = session.createQuery("from Topic").list();
			session.getTransaction().commit();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}


	public Topic getTopicById(int id) {
		
		Session session= null;
		Topic topic = null;
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			topic = (Topic) session.get(Topic.class, id);
			session.getTransaction().commit();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return topic;
		

	}


}
