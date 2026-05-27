package me.study.todo.dto;

public class DdayDeleteRespDto {

    private Long ddayId;
    private String message;

    public DdayDeleteRespDto() {
    }

    public DdayDeleteRespDto(Long ddayId, String message) {
        this.ddayId = ddayId;
        this.message = message;
    }

    public Long getDdayId() {
        return ddayId;
    }

    public String getMessage() {
        return message;
    }
}