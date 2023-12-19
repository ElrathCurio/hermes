package com.docta.ai.hermes;

import com.docta.ai.hermes.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class HermesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HermesApplication.class, args);
	}

}
