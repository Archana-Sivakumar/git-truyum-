package com.cognizant.medicare.service;


import org.springframework.stereotype.Service;
import com.cognizant.medicare.model.TestResult;

@Service
public interface TestResultService {

	public TestResult getTestResult(int requestId);
}
