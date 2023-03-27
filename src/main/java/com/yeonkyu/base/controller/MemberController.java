package com.yeonkyu.base.controller;

import com.yeonkyu.base.domain.Member;
import com.yeonkyu.base.dto.member.MemberRegisterDto;
import com.yeonkyu.base.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String memberLoginForm(Model model) {
        log.info("memberLoginForm");
        model.addAttribute("form", new MemberRegisterDto());
        return "member/login";
    }

    @GetMapping("/signup")
    public String memberSignUpForm(Model model) {
        log.info("memberSignUpForm");
        model.addAttribute("form", new MemberRegisterDto());
        return "member/signUp";
    }

    @PostMapping("/signup_proc")
    public String memberSignUpProcess(@ModelAttribute MemberRegisterDto form) {
        log.info("form = {}", form);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(form.getPassword());
        Member registerMember = new Member(
                form.getEmail(),
                encodePassword,
                form.getUserName(),
                form.getPhoneNumber(),
                form.getNickName(),
                form.getEmailCheck()
        );

        log.info("Register Member : {}", registerMember);

        memberService.saveMember(registerMember);
        return "redirect:/member/login";
    }

}

