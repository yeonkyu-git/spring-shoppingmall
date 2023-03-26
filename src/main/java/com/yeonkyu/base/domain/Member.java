package com.yeonkyu.base.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    private Long memberId;
    private String email;
    private String password;
    private String userName;
    private String phoneNumber;
    private String nickName;
    private String emailCheck;
    private String role;
    private String grade;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public Member(String email, String password, String userName, String phoneNumber, String nickName, String emailCheck) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
        this.emailCheck = emailCheck;
        this.role = "MEMBER";
        this.grade = "BRONZE";
        this.regDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }


    /* MyBatis useGeneratedKeys 사용으로 인한 memberId Setter 등록 */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
