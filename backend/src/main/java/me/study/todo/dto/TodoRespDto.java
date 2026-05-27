package me.study.todo.dto;

public class TodoRespDto {

    private Long todoId;
    private String content;
    private Boolean done;
    private Integer displayOrder;

    public TodoRespDto() {
    }

    public TodoRespDto(Long todoId, String content, Boolean done, Integer displayOrder) {
        this.todoId = todoId;
        this.content = content;
        this.done = done;
        this.displayOrder = displayOrder;
    }

    public Long getTodoId() {
        return todoId;
    }

    public String getContent() {
        return content;
    }

    public Boolean getDone() {
        return done;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }
}