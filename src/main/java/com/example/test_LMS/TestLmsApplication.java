package com.example.test_LMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TestLmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestLmsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {

			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry
							.addMapping("/**")
							.allowedMethods(CorsConfiguration.ALL)
							.allowedHeaders(CorsConfiguration.ALL)
							.allowCredentials(true)
							.allowedOriginPatterns(CorsConfiguration.ALL);
				}
			};
	}

}
