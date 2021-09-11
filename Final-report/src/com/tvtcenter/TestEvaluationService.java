package com.tvtcenter;

import java.util.ArrayList;
import java.util.Map;

public class TestEvaluationService {
	
	
	

	public TestResultDO evaluate(Map<String, Integer> testStore) {
		if (testStore == null || testStore.size() < 15) {
			return null;
		}
		
		TestResultDO testResult = new TestResultDO();
		
		ArrayList<Integer> correct = new ArrayList<Integer>();
		ArrayList<Integer> incorrect = new ArrayList<Integer>();

		int scoreSum = 0;
		for (int i=1; i<=15; i++) {
			scoreSum += testStore.get("q"+i);
			if(testStore.get("q"+i) == 0) {
				incorrect.add(i);
			}
			else if(testStore.get("q"+i) != 1) {
				correct.add(i);
			}
		}
		
		int totalScore = 0;
		
		totalScore = scoreSum * 15;
		testResult.setScore(totalScore);
		testResult.setCorrect(correct);
		testResult.setIncorrect(incorrect);

		
		return testResult;
	}

}
