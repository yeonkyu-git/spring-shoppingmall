package com.yeonkyu.base.repository.mapper;

import com.yeonkyu.base.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    void saveMember(@Param("member") Member member);

    Optional<Member> findById(@Param("memberId") Long memberId);

    Optional<Member> findByEmail(@Param("email") String email);

    List<Member> findAll();

    void updateMember(@Param("member") Member member);
}
