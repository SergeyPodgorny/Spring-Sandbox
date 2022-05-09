package com.springcontext.springcontext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringcontextApplication {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml"); 
		
		
		HandsomnesContest contest = context.getBean(HandsomnesContestImpl.class);
		
		contest.evaluateHandsomnes();
		
		
		
		
		
	}

}
