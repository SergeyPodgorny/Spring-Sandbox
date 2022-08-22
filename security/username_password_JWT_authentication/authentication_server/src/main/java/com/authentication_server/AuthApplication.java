package com.authentication_server;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication implements CommandLineRunner{

	
	@Value("${variable.settings.security.access_secret}")
	private String jwtAccessSecret;
	
	@Value("${variable.settings.security.access_expiration}")
	private Long accessTokenExpirationDuration;	
	
	@Value("${variable.settings.security.refresh_secret}")
	private String jwtRefreshSecret;
	
	@Value("${variable.settings.security.refresh_expiration}")
	private Long refreshTokenExpirationDuration;	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);

	}

	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(jwtAccessSecret);
		System.out.println(accessTokenExpirationDuration);
		
		
		System.out.println(jwtRefreshSecret);
		System.out.println(refreshTokenExpirationDuration);
	}
	
	
	
	
}
