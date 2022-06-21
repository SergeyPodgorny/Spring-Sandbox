package com.springcontext.springcontext;

import java.lang.reflect.Field;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

public class CalculateHandsomnesBeanPostProcessorImpl implements BeanPostProcessor {

	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		Field[] declaredFields = bean.getClass().getDeclaredFields();
		
		for(Field field : declaredFields) {
			CalculateHandsomnes annotation = field.getAnnotation(CalculateHandsomnes.class);
			if(annotation != null) {
				int min = annotation.minHandsomnes();
				int max = annotation.maxHandsomnes();
				Random random = new Random();
				int randomNumber = min + random.nextInt((max-min));
				field.setAccessible(true);
				ReflectionUtils.setField(field, bean, randomNumber);
			}
		}
		
		
		
		return bean;
	}
	
	
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	
	
}
