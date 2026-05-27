package me.study.todo.dto;

public class DdayRespDto {

    private Long ddayId;
    private String title;
    private String targetDate;
    private String message;

    public DdayRespDto() {
    }

    public DdayRespDto(Long ddayId, String title, String targetDate, String message) {
        this.ddayId = ddayId;
        this.title = title;
        this.targetDate = targetDate;
        this.message = message;
    }

    public Long getDdayId() {
        return ddayId;
    }

    public String getTitle() {
        return title;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public String getMessage() {
        return message;
    }
}