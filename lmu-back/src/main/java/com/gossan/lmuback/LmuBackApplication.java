package com.gossan.lmuback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LmuBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmuBackApplication.class, args);
		/*ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(LmuBackApplication.class)
				.properties("spring.config.name:lmu-back",
						"spring.config.location:classpath:/application.properties")
				.build()
				.run(args);*/
	}
}
