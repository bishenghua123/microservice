package com.hjh.microservice.eureka.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WordServiceImpl implements WordService {

	@Autowired
    SubjectClient subjectClient;
    @Autowired
    SubjectClient1 subjectClient1;
    @Autowired
    SubjectClient2 subjectClient2;
	
	@Override
    @HystrixCommand(fallbackMethod="getFallbackSubject")
    public String getSubject() {
        return subjectClient.getWord();
    }

	@Override
    @HystrixCommand(fallbackMethod="getFallbackSubject1")
    public String getSubject1() {
        return subjectClient1.getWord();
    }

	@Override
    @HystrixCommand(fallbackMethod="getFallbackSubject2")
    public String getSubject2() {
        return subjectClient2.getWord();
    }
    
    public String getFallbackSubject() {
        return "某人";
    }

    public String getFallbackSubject1() {
        return "某事";
    }

    public String getFallbackSubject2() {
        return "某物";
    }
}
