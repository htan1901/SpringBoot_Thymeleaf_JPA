package com.example.todo_list.config;

import com.example.todo_list.model.TodoValidator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
	@Bean
	public TodoValidator validator() {
		return new TodoValidator();
	}
}
