package com.yeonkyu.base.controller;

import com.yeonkyu.base.domain.Member;
import com.yeonkyu.base.dto.member.MemberRegisterDto;
import com.yeonkyu.base.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberApiController {

    private final MemberService memberService;


    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/signup")
    public Member signup(@RequestBody MemberRegisterDto memberRegisterDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(memberRegisterDto.getPassword());
        Member member = new Member(
                memberRegisterDto.getEmail(),
                encodePassword,
                memberRegisterDto.getUserName(),
                memberRegisterDto.getPhoneNumber(),
                memberRegisterDto.getNickName(),
                memberRegisterDto.getEmailCheck()
        );
        memberService.saveMember(member);

        return member;
    }
}
