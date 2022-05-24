package com.jarl.artodo;

import com.jarl.artodo.shared.domain.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"com.jarl.artodo"}
)
public class ArTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArTodoApplication.class, args);
	}

}
