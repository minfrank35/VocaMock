package com.tvtcenter;

public class QuestionDO {
	private int id;
	private String question;
	private String[] items;
	private int[] scores;
	
	
	public QuestionDO(int id, String question, String[] items, int[] scores) {
		this.id = id;
		this.question = question;
		this.items = items;
		this.scores = scores;
	}
	
	public QuestionDO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getItems() {
		return items;
	}
	public void setItems(String[] items) {
		this.items = items;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
}
