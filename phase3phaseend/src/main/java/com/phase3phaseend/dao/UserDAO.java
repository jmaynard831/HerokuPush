package com.phase3phaseend.dao;

import org.springframework.data.repository.CrudRepository;

import com.phase3phaseend.entity.User;

public interface UserDAO extends CrudRepository<User, Integer>{

}
