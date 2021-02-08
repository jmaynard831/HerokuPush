package com.jwtTestTwo.jwtTestTwo.todo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/todo")
public class TodoController {

	Logger logging = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired 
	private TodoService todoservice;
	
	
	@GetMapping
	public List<Todo> getAllTodo(){
		logging.error("All Todo Accessed");
		return todoservice.getAllTodo();
	}
	
	@PostMapping
	public void saveTodo(@RequestBody Todo t) {
		logging.error("Saving todo: "+ t.toString());
		todoservice.saveTodo(t);
	}
}
