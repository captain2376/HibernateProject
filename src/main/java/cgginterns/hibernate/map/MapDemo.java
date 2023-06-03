package cgginterns.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// create question object

		Question q = new Question();
		q.setQuestionId(1212);
		q.setQuestion("Who are you?");

		// Creating answer object
		Answer a = new Answer();
		a.setAnswerId(343);
		a.setAnswer("Programmer");

		// set answer field in question foreign key and viceversa
		q.setAnswer(a);
		a.setQuestion(q);
		// create question object

		Question q1 = new Question();
		q1.setQuestionId(242);
		q1.setQuestion("What is your job?");

		// Creating answer object
		Answer a1 = new Answer();
		a1.setAnswerId(34);
		a1.setAnswer("write programs");

		// set answer field in question foreign key and viceversa
		q1.setAnswer(a1);
		a1.setQuestion(q1);

		//ask factory to give session
		
		Session s = factory.openSession();
		
		Transaction t = s.beginTransaction();
		
		//save questions in question table
		s.save(q);
		s.save(q1);
		
		//save answers in answer table
		s.save(a);
		s.save(a1);
		
		t.commit();
		
		//fetching objects.........
//			Question question=(Question)s.get(Question.class,1212);//supply id -retrieve question
//			
//			System.out.println(question.getQuestion());//
//		
//			System.out.println(question.getAnswer().getAnswer());//answer object
//			
	
			//based on answer
		Answer ans=(Answer)s.get(Answer.class, 344);
		System.out.println(ans.getAnswer());
		System.out.println(ans.getQuestion());
		s.close();
		
		factory.close();

	}

}
