package me.study.todo.dto;

import java.util.List;

public class TodoListRespDto {

    private Long userId;
    private String date;
    private List<TodoRespDto> todos;

    public TodoListRespDto() {
    }

    public TodoListRespDto(Long userId, String date, List<TodoRespDto> todos) {
        this.userId = userId;
        this.date = date;
        this.todos = todos;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public List<TodoRespDto> getTodos() {
        return todos;
    }
}