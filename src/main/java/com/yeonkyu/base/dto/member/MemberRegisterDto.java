package com.yeonkyu.base.dto.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberRegisterDto {
    private String email;
    private String password;
    private String userName;
    private String phoneNumber;
    private String nickName;
    private String emailCheck;

}
