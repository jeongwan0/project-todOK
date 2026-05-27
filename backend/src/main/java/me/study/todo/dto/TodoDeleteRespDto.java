package me.study.todo.dto;

public class TodoDeleteRespDto {

    private Long todoId;
    private String message;

    public TodoDeleteRespDto() {
    }

    public TodoDeleteRespDto(Long todoId, String message) {
        this.todoId = todoId;
        this.message = message;
    }

    public Long getTodoId() {
        return todoId;
    }

    public String getMessage() {
        return message;
    }
}