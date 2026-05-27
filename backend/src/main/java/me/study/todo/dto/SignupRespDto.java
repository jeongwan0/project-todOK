package me.study.todo.dto;

public class SignupRespDto {

    private Long userId;
    private String loginId;
    private String nickname;
    private String message;

    public SignupRespDto() {
    }

    public SignupRespDto(Long userId, String loginId, String nickname, String message) {
        this.userId = userId;
        this.loginId = loginId;
        this.nickname = nickname;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }
}