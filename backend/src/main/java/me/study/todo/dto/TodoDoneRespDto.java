package me.study.todo.dto;

public class TodoDoneRespDto {

    private Long todoId;
    private Boolean done;
    private String message;

    public TodoDoneRespDto() {
    }

    public TodoDoneRespDto(Long todoId, Boolean done, String message) {
        this.todoId = todoId;
        this.done = done;
        this.message = message;
    }

    public Long getTodoId() {
        return todoId;
    }

    public Boolean getDone() {
        return done;
    }

    public String getMessage() {
        return message;
    }
}