package com.example.todo_list.service;

import java.util.List;

import com.example.todo_list.model.Todo;
import com.example.todo_list.model.TodoValidator;
import com.example.todo_list.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private TodoValidator todoValidator;

	public List<Todo> listAll() {
		return todoRepository.findAll();
	}

	public Todo addTodo(Todo todo) {
		if(todoValidator.isValid(todo)) 
			return todoRepository.save(todo);
		return null;
	}
}
