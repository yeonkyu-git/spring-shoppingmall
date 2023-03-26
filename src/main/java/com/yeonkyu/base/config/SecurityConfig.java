package com.yeonkyu.base.config;

import com.yeonkyu.base.handler.MyLoginSuccessHandler;
import com.yeonkyu.base.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    String roles [] = new String[] {"USER", "ADMIN"};

    private final MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/member/login", "/member/signup", "/resources/**", "/api/member/signup", "/member/login_proc").permitAll() // 로그인 권한은 누구나, resources 파일도 모든권한
                    .antMatchers("/**").hasAnyRole(roles)
                .and()
                    .formLogin()
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginPage("/member/login")
                    .loginProcessingUrl("/member/login_proc")
                    .defaultSuccessUrl("/")
                    .successHandler(new MyLoginSuccessHandler())
                    .failureUrl("/member/login")
                .and()
                    .logout()
                    .logoutUrl("/member/logout")
                    .logoutSuccessUrl("/")
                .and()
                    .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
