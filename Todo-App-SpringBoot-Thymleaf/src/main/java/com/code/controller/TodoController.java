package com.code.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.code.entity.Todo;

import jakarta.servlet.http.HttpSession;

//Coded by AKYADAV in 2K26
@Controller
@RequestMapping({ "/todos", "/" })
public class TodoController {

	@GetMapping
	public String listTodos(HttpSession session, Model model) {
		List<Todo> todos = getTodos(session);
		model.addAttribute("todos", todos);
		return "todo-list";
	}

	@PostMapping("/add")
	public String addTodo(@RequestParam String task, HttpSession session, RedirectAttributes redirectAttributes) {

		if (task == null || task.trim().isEmpty()) {
			redirectAttributes.addFlashAttribute("errMessage", "Please Enter SomeThing in the Text Box");
			return "redirect:/todos";
		}
		List<Todo> todos = getTodos(session);
		todos.add(new Todo(task, false));
		return "redirect:/todos";
	}

	@PostMapping("/toggle/{index}")
	public String toggleTodo(@PathVariable int index, HttpSession session) {
		List<Todo> todos = getTodos(session);
		if (index >= 0 && index < todos.size()) {
			Todo todo = todos.get(index);
			todo.setDone(!todo.isDone());
		}
		return "redirect:/todos";
	}

	@SuppressWarnings("unchecked")
	private List<Todo> getTodos(HttpSession session) {
		List<Todo> todos = (List<Todo>) session.getAttribute("todos");
		if (todos == null) {
			todos = new ArrayList<>();
			session.setAttribute("todos", todos);
		}
		return todos;
	}

}
