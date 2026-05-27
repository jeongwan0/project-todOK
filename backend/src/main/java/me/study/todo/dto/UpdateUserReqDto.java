package me.study.todo.dto;

public class UpdateUserReqDto {

    private String nickname;
    private String password;
    private String ddayname;
    private String ddaydate;
    private Integer ddaynum;

    public UpdateUserReqDto() {
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
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
}