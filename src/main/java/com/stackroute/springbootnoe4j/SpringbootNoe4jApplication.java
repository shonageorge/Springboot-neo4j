package com.stackroute.springbootnoe4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class SpringbootNoe4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootNoe4jApplication.class, args);
	}

}
