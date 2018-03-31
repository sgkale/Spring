package com.capco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.capco")
@ComponentScan("com.capco")
@EntityScan("com.capco")
@EnableDiscoveryClient
public class AccomodationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccomodationServiceApplication.class, args);
	}
}
