package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	int maxCount =3;
	int count =1;
	
	public boolean retry(ITestResult result) {
		//  1	<   3
		if(count<maxCount) {//1--T, 2--T, 3--F
			count++;
			return true;
		}
		return false;
	}

}
