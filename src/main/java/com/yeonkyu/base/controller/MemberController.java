package com.yeonkyu.base.controller;

import com.yeonkyu.base.domain.Member;
import com.yeonkyu.base.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/login")
    public String memberLoginForm() {
        return "member/login";
    }

    @GetMapping("/member/signup")
    public String memberSignUpForm() {
        return "member/signUp";
    }


}

