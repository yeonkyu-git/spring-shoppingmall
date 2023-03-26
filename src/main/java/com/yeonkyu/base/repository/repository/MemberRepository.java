package com.yeonkyu.base.repository.repository;

import com.yeonkyu.base.domain.Member;
import com.yeonkyu.base.repository.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberMapper memberMapper;

    public void saveMember(Member member) {
        memberMapper.saveMember(member);
    }

    public Optional<Member> findById(Long memberId) {
        return memberMapper.findById(memberId);
    }

    public Optional<Member> findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }

    public List<Member> findMembers() {
        return memberMapper.findAll();
    }

    public void updateMember(Member member) {
        memberMapper.updateMember(member);
    }
}
