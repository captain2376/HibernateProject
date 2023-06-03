package cgginterns.hibernate.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
		@Id
		@Column(name="question_id")
		private int questionId;
		private String question;
		
		@OneToMany(mappedBy="question")
		private List<Answer> answers;//one question has many answers so its a list
		
		
		public Question(int questionId, String question) {
			super();
			this.questionId = questionId;
			this.question = question;
		}
		public Question() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getQuestionId() {
			return questionId;
		}
		public void setQuestionId(int questionId) {
			this.questionId = questionId;
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public List<Answer> getAnswers() {
			return answers;
		}
		public void setAnswers(List<Answer> answers) {
			this.answers = answers;
		}
		
		
}
