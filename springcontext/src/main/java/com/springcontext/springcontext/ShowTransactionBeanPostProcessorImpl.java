package com.springcontext.springcontext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class ShowTransactionBeanPostProcessorImpl implements BeanPostProcessor {
	
	Map<String, Class<?>> beanStorage = new HashMap<>();
	
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		Class<?> currentBean = bean.getClass();
				
		if(currentBean.isAnnotationPresent(ShowTransaction.class)) {
			
			beanStorage.put(beanName, currentBean);
			
			
		}
		
		
		return bean;
	}
	
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		Class<?> currentBean = beanStorage.get(beanName);
		
//		InvocationHandler i1 = (Object proxy, Method method, Object[] args) -> {
//			System.out.println("Open transaction");
//			Instant startTime = Instant.now();
//			Object result = method.invoke(bean, args);
//			Instant endTime = Instant.now();
//			System.out.println(Duration.between(startTime, endTime));
//			System.out.println("Close transaction");
//			return result;
//		};
		
		if(currentBean != null) {
			return Proxy.newProxyInstance(currentBean.getClassLoader(), currentBean.getInterfaces(), new InvocationHandler(){
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
					System.out.println("Open transaction");
					Instant startTime = Instant.now();
					Object result = method.invoke(bean, args);
					Instant endTime = Instant.now();
					System.out.println(Duration.between(startTime, endTime));
					System.out.println("Close transaction");
					return result;
				}
				
			}); 
				
		
		}
		
		
		
		
		
		return bean;
	}
	
	

}
