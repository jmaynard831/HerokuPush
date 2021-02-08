package com.jwtTestTwo.jwtTestTwo.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TodoDAO extends JpaRepository<Todo, Integer> {

}
