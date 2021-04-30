package dev.rokas.task.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RentInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentInformationApplication.class, args);
	}

}
