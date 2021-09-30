package com.example.todo_list.controller;

import com.example.todo_list.model.Todo;
import com.example.todo_list.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("/")
	public String listTodo(Model model) {
		model.addAttribute("listTodo", todoService.listAll());
		return "list_todo";
	}

	@GetMapping("/add")
	public String addTodo(Model model) {
		model.addAttribute("todo", new Todo());
		return "add_todo";
	}

	@PostMapping("/")
	public String addTodo(Model model, @ModelAttribute Todo todo) {
		if(todo.equals(null))
			return listTodo(model);
		todoService.addTodo(todo);
		return listTodo(model);
	}
}
