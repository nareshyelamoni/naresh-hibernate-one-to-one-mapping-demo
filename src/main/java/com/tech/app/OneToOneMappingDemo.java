package com.tech.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.tech.model.Answer;
import com.tech.model.Question;

import jakarta.persistence.EntityExistsException;

public class OneToOneMappingDemo {

	public static void main(String[] args) {
		//Configuration config=null;
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			sessionFactory=new Configuration().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class).buildSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Question q=new Question();
			q.setqId(2);
			q.setQuestion("What is Java?");
			
			Answer ans=new Answer();
			ans.setaId(2);
			ans.setAnswer("java is a programming language");
			
			q.setAnswer(ans);
			
			Question q1=new Question();
			q1.setqId(3);
			q1.setQuestion("What is JPA?");
			
			Answer ans1=new Answer();
			ans1.setaId(3);
			ans1.setAnswer("It is a specification used to persist "+"data between java object and relational database");
		
			q1.setAnswer(ans1);
			session.persist(q);
			session.persist(q1);
			transaction.commit();
			System.out.println("Transaction commited succesfully...........");
			flag=true;
		}catch (EntityExistsException e) {
			System.out.println("Entity already exists: "+e.getMessage());
		}catch (ConstraintViolationException e) {
			System.out.println("Constraint violation: "+e.getMessage());
		}catch (HibernateException e) {
			System.out.println("Hibernate Exception: "+e.getMessage());
		}catch (Exception e) {
			System.out.println("Unexpected exception: "+e.getMessage());
		}finally {
			if(!flag) {
				if(transaction!=null) {
					transaction.rollback();
					System.out.println("Transaction rolled back successfully");
				}
			}
			if(session!=null) {
				session.close();
			}
			if(sessionFactory!=null) {
				sessionFactory.close();
			}
		}

	}

}
