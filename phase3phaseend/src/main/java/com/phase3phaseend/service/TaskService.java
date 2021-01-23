package com.phase3phaseend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3phaseend.dao.TaskDAO;
import com.phase3phaseend.entity.Task;
import com.phase3phaseend.exception.DeletingFromDatabaseException;
import com.phase3phaseend.exception.ReadingFromDatabaseException;
import com.phase3phaseend.exception.SaveToDatabaseException;

@Service
public class TaskService {

	@Autowired
	private TaskDAO taskdao;

	public boolean saveTask(Task t) throws SaveToDatabaseException {
		try {
			taskdao.save(t);
			return true;
		} catch (Throwable e) {
			throw new SaveToDatabaseException("Error saving task to the database.", e);
		}

		//return false;

	}

	public List<Task> getAllTasks() {
		return (List<Task>) taskdao.findAll();
	}

	public void deleteTask(Integer taskID) throws DeletingFromDatabaseException {
		try {
			taskdao.deleteById(taskID);
		} catch (Throwable e) {
			throw new DeletingFromDatabaseException("Error deleting task from the database.", e);
		}
	}

	public Task getTask(Integer taskID) throws ReadingFromDatabaseException {
		try {
			return (Task) taskdao.findById(taskID).get();
		} catch (Throwable e) {
			throw new ReadingFromDatabaseException("Error reading task from the database.", e);
		}
		//return null;
	}

}
