package com.phase3phaseend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phase3phaseend.entity.Task;
import com.phase3phaseend.exception.ReadingFromDatabaseException;
import com.phase3phaseend.exception.SaveToDatabaseException;
import com.phase3phaseend.service.TaskService;
import com.phase3phaseend.service.UserService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskservice;

	@GetMapping("/creation")
	public String createTask() {
		if (UserService.LoggedIn != null) {
			return "creation";
		}
		return "error";
	}

	@PostMapping("/creation")
	public String createTask(@Valid Task t) throws SaveToDatabaseException {

		if (taskservice.saveTask(t)) {
			return "redirect:/display";
		} else {
			return "error";
		}

	}

	@GetMapping("/delete")
	public String deleteTask(@RequestParam("taskID") Integer taskID) {
		
		try {
			taskservice.deleteTask(taskID);
			return "redirect:/display";
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return "redirect:/error";
	}

	@GetMapping("/update")
	public ModelAndView updateTask(@RequestParam("taskID") Integer taskID, ModelMap model) throws ReadingFromDatabaseException {
		Task t = taskservice.getTask(taskID);
		model.addAttribute("task", t);
		return new ModelAndView("update", model);
	}

	@PostMapping("/update")
	public String updateTask(Task t) throws SaveToDatabaseException {
		t.getEndDate().toString().substring(0, 11);
		if (taskservice.saveTask(t)) {
			return "redirect:/display";
		} else {
			return "error";
		}
	}

	@GetMapping("/display")
	public ModelAndView displayTask(ModelMap model) {
		if (UserService.LoggedIn != null) {
		model.addAttribute("tasks", taskservice.getAllTasks());
		return new ModelAndView("display", model);
		}
		return new ModelAndView("error");
	}
}
