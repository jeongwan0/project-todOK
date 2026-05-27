package me.study.todo.dto;

public class TodoUpdateRespDto {

    private Long todoId;
    private String content;
    private Integer displayOrder;
    private String message;

    public TodoUpdateRespDto() {
    }

    public TodoUpdateRespDto(Long todoId, String content, Integer displayOrder, String message) {
        this.todoId = todoId;
        this.content = content;
        this.displayOrder = displayOrder;
        this.message = message;
    }

    public Long getTodoId() {
        return todoId;
    }

    public String getContent() {
        return content;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public String getMessage() {
        return message;
    }
}