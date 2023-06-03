package cgginterns.hibernate.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemoManyToOne {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// create question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");

		// create answer
		Answer a1 = new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("Programming Language");
		a1.setQuestion(q1);

		Answer a2 = new Answer();
		a2.setAnswerId(1);
		a2.setAnswer("Java is Platform Independent");
		a2.setQuestion(q1);
		
		Answer a3 = new Answer();
		a3.setAnswerId(2);
		a3.setAnswer("It is used to build applications");
		a3.setQuestion(q1);

		// create a list of answers
		ArrayList<Answer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		// add list of answers
		q1.setAnswers(list);

		// ------------------------------

		// 2nd question//create question
		Question q2 = new Question();
		q2.setQuestionId(212);
		q2.setQuestion("What is netbeans?");

		// create answer
		Answer aq21 = new Answer();
		aq21.setAnswerId(43);
		aq21.setAnswer("IDE");
		aq21.setQuestion(q2);

		Answer aq22 = new Answer();
		aq22.setAnswerId(122);
		aq22.setAnswer(" Platform Independent");
		aq22.setQuestion(q2);
		
		
		Answer aq23 = new Answer();
		aq23.setAnswerId(23);
		aq23.setAnswer("It helps to build applications");
		aq23.setQuestion(q2);

		// create a list of answers
		ArrayList<Answer> list1 = new ArrayList<>();
		list1.add(aq21);
		list1.add(aq22);
		list1.add(aq23);
		// add list of answers
		q2.setAnswers(list1);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(q1);

		session.save(a1);
		session.save(a2);
		session.save(a3);
		// -------------------
		session.save(q2);

		session.save(aq21);
		session.save(aq22);
		session.save(aq23);

		tx.commit();
//fetch data
//		
	Question question =(Question) session.load(Question.class, 212);
		System.out.println(question.getQuestion());
		
		List<Answer> answers = question.getAnswers();
		for(Answer answer: answers) {
			System.out.println(answer.getAnswer());
		}
		
		factory.close();
	}

}
