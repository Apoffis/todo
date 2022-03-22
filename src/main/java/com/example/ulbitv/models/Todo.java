package com.example.ulbitv.models;

import com.example.ulbitv.entity.TodoEntity;

public class Todo {

    private Long id;

    private String title;

    private boolean completed;

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.isCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }
}
