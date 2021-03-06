package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.AssigneeService;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;
    private AssigneeService assigneeService;

    public TodoController(TodoService todoService, AssigneeService assigneeService) {
        this.todoService = todoService;
        this.assigneeService = assigneeService;
    }

    @RequestMapping(value={"/list", "/", ""}, method= RequestMethod.GET)
    public String list(@RequestParam (required = false) String isActive, Model model, @RequestParam (required = false) String search) {
        if (search != null) {
            model.addAttribute("todos", todoService.findAllByTitleContains(search));
        } else if (isActive == null) {
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
    public String addForm(Model model) {
        model.addAttribute("assignees", assigneeService.findAll());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Todo todo) {
        todoService.add(todo);
        return "redirect:/todo";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("todo", todoService.findTodoById(id));
        model.addAttribute("persons", assigneeService.findAll());
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@ModelAttribute Todo todo) {
        todoService.edit(todo);
        return "redirect:/todo";
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @GetMapping("/search-result")
    public String showSearchResult() {
        return "search-result";
    }
}
