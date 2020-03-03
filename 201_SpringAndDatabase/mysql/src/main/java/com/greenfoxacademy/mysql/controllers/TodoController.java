package com.greenfoxacademy.mysql.controllers;

import com.greenfoxacademy.mysql.repositories.TodoRepository;
import com.greenfoxacademy.mysql.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value={"/list", "/", ""}, method= RequestMethod.GET)
    public String list(@RequestParam (required = false) String isActive, Model model) {
        if (isActive == null) {
            model.addAttribute("todos", todoService.findAll());
        } else if (isActive.toLowerCase().equals("true")) {
            model.addAttribute("todos", todoService.findAllByIsNotDone());
        } else if (isActive.toLowerCase().equals("false")) {
            model.addAttribute("todos", todoService.findAllByIsDone());
        } else {
            model.addAttribute("error", "Please write a valid query.");
        }
        return "todolist";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodoById(@PathVariable Long id) {
        todoService.deleteById(id);
        return "redirect:/todo";
    }

    @GetMapping("/add")
    public String addForm() {
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name="title") String title) {
        todoService.add(title);
        return "redirect:/todo";
    }
}
