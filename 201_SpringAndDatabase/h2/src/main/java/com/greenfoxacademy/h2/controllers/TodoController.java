package com.greenfoxacademy.h2.controllers;

import com.greenfoxacademy.h2.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @RequestMapping(value={"/list", "/", ""}, method= RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todolist";
    }
}
