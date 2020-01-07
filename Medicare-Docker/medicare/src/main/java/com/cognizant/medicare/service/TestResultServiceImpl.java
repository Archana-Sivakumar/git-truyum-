package com.cognizant.medicare.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicare.MedicareApplication;
import com.cognizant.medicare.model.TestResult;
import com.cognizant.medicare.repository.TestResultRepository;


@Service
public class TestResultServiceImpl implements TestResultService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MedicareApplication.class);

	@Autowired
	TestResultRepository testResultRepository;
	
	@Override
	public TestResult getTestResult(int requestId) {
		
		LOGGER.info("START");
		LOGGER.info("END");
		
		return testResultRepository.getTestResult(requestId);
	}
	
	

}
