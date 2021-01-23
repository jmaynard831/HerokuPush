package com.phase3phaseend.phase3phaseend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com")
@EnableJpaRepositories(basePackages="com")
@EntityScan(basePackages="com")
public class Phase3phaseendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Phase3phaseendApplication.class, args);
	}	

}
