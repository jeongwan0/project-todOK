package me.study.todo.dto;

public class LoginRespDto {

    private Long userId;
    private String loginId;
    private String nickname;
    private String message;
    private String ddayname;
    private String ddaydate;
    private Integer ddaynum;
    private String password;

    public LoginRespDto() {
    }

    public LoginRespDto(Long userId, String loginId, String nickname,
                        String password,
                        String ddayname, String ddaydate, Integer ddaynum,
                        String message) {
        this.userId = userId;
        this.loginId = loginId;
        this.nickname = nickname;
        this.password = password;
        this.ddayname = ddayname;
        this.ddaydate = ddaydate;
        this.ddaynum = ddaynum;
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

    public String getDdayname() {
        return ddayname;
    }

    public String getDdaydate() {
        return ddaydate;
    }

    public Integer getDdaynum() {
        return ddaynum;
    }

    public String getPassword() {
        return password;
    }
}