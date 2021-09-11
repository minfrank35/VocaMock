package com.tvtcenter;

import java.util.ArrayList;

public class TestResultDO {
	private int score;
	private String result;
	private String Id;
	private int number;
	private ArrayList<Integer> correct;
	private ArrayList<Integer> incorrect;

	public TestResultDO() {
	}
	public ArrayList<Integer> getCorrect() {
		return correct;
	}

	public void setCorrect(ArrayList<Integer> correct) {
		this.correct = correct;
	}

	public ArrayList<Integer> getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(ArrayList<Integer> incorrect) {
		this.incorrect = incorrect;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public TestResultDO(int score, String result) {
		this.score = score;
		this.result = result;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}	
}
