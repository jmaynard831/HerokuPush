package com.jwtTestTwo.jwtTestTwo.todo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private TodoDAO tododao;


	public TodoService(TodoDAO tododao) {
		super();
		this.tododao = tododao;
	}

	public void saveTodo(Todo t) {
		tododao.save(t);
	}
	
	public List<Todo> getAllTodo(){
		return tododao.findAll();
	}
}
