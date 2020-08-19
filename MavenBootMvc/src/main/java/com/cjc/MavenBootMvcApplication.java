package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@EntityScan
@SpringBootApplication
public class MavenBootMvcApplication {
     
	public static void main(String[] args) {
	
		SpringApplication.run(MavenBootMvcApplication.class, args);
		System.out.println("hi");
	}

}
