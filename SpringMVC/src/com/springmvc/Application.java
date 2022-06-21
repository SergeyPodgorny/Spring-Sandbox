package com.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.springmvc.configuration.ApplicationConfig;

public class Application implements WebApplicationInitializer {
		
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext annotationContext = new AnnotationConfigWebApplicationContext();
		annotationContext.register(ApplicationConfig.class);
		servletContext.addListener(new ContextLoaderListener(annotationContext));
		
		
		ServletRegistration.Dynamic servlet = 
				servletContext.addServlet("dispatcher", new DispatcherServlet(annotationContext));
//		servlet.addMapping("/");
//		servlet.setLoadOnStartup(1);
		
	}
	
	
	
	
	

}
