package com.nit.main;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootErailRestApi1Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringbootErailRestApi1Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8888")); // Overrides properties file
		app.run(args);
	}

}
