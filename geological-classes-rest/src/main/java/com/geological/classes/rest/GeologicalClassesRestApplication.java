package com.geological.classes.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
  "com.geological.classes.core.*",
  "com.geological.classes.data.access.*",
  "com.geological.classes.data.transfer.*",
  "com.geological.classes.rest.*"
})
@EnableJpaRepositories(basePackages = {"com.geological.classes.data.access.repository"})
@EntityScan(value = "com.geological.classes.data.access.entity")
@SpringBootApplication
public class GeologicalClassesRestApplication {

  public static void main(String[] args) {
    SpringApplication.run(GeologicalClassesRestApplication.class, args);
  }
}
