package com.nekit.ssn;

import io.sentry.Sentry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsnApplication {
	public static void main(String[] args) {
		Sentry.capture("Application started");
		SpringApplication.run(SsnApplication.class, args);
	}

}
