package com.springcontext.springcontext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

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
		
		InvocationHandler i1 = (Object arg0, Method arg1, Object[] arg2) -> {
			return null;
			
		};
		
		if(currentBean != null) {
			return Proxy.newProxyInstance(currentBean.getClassLoader(), currentBean.getInterfaces(), i1); 
				
		
		}
		
		
		
		
		
		return bean;
	}
	
	

}
