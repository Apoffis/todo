package com.example.ulbitv.service;

import com.example.ulbitv.entity.TodoEntity;
import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.models.Todo;
import com.example.ulbitv.rpository.TodoRepository;
import com.example.ulbitv.rpository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public Todo createTodo(TodoEntity todo, Long userId) {

        UserEntity user = userRepository.findById(userId).get();

        todo.setUser(user);

        return Todo.toModel(todoRepository.save(todo));

    }

    public Todo completeTodo(Long userId) {
        TodoEntity todo = todoRepository.findById(userId).get();
        todo.setCompleted(!todo.isCompleted());
        return Todo.toModel(todoRepository.save(todo));
    }
}
