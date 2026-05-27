package me.study.todo.dto;

public class TodoAddRespDto {

    private Long todoId;
    private String content;
    private String message;

    public TodoAddRespDto() {
    }

    public TodoAddRespDto(Long todoId, String content, String message) {
        this.todoId = todoId;
        this.content = content;
        this.message = message;
    }

    public Long getTodoId() {
        return todoId;
    }

    public String getContent() {
        return content;
    }

    public String getMessage() {
        return message;
    }
}