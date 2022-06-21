package com.springcontext.springcontext;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface CalculateHandsomnes {

	
	

	int minHandsomnes();
	
	int maxHandsomnes();
	
	
		
}
