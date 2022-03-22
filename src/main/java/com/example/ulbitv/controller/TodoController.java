package com.example.ulbitv.controller;

import com.example.ulbitv.entity.TodoEntity;
import com.example.ulbitv.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Something Wrong!");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.completeTodo(userId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Something Wrong!");
        }
    }

}
