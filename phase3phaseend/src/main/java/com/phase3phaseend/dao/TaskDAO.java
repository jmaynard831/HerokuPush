package com.phase3phaseend.dao;

import org.springframework.data.repository.CrudRepository;

import com.phase3phaseend.entity.Task;

public interface TaskDAO extends CrudRepository<Task, Integer> {

}
