package me.study.todo.dto;

import java.util.List;

public class DdayListRespDto {

    private Long userId;
    private List<DdayRespDto> ddays;

    public DdayListRespDto() {
    }

    public DdayListRespDto(Long userId, List<DdayRespDto> ddays) {
        this.userId = userId;
        this.ddays = ddays;
    }

    public Long getUserId() {
        return userId;
    }

    public List<DdayRespDto> getDdays() {
        return ddays;
    }
}