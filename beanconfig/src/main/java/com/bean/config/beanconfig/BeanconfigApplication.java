package com.bean.config.beanconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-context.xml")
public class BeanconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanconfigApplication.class, args);
	}

}
