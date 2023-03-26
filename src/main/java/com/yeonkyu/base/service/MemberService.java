package com.yeonkyu.base.service;

import com.yeonkyu.base.domain.Member;
import com.yeonkyu.base.domain.MemberVO;
import com.yeonkyu.base.repository.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Transactional
    public void saveMember(Member member) {
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());

        if (findMember.isPresent()) {
            throw new RuntimeException("이미 가입되어 있는 이메일입니다.");
        }
        memberRepository.saveMember(member);
    }

    public Member findById(Long memberId) {
        Optional<Member> findMember = memberRepository.findById(memberId);

        if (findMember.isEmpty()) {
            throw new RuntimeException("찾으려는 회원이 없다.");
        }

        return findMember.get();
    }

    public List<Member> findMembers() {
        return memberRepository.findMembers();
    }

    @Transactional
    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> findMemberOptional = memberRepository.findByEmail(email);

        if (findMemberOptional.isEmpty()) {
            throw new UsernameNotFoundException("해당 이메일을 가진 회원이 존재하지 않습니다.");
        }

        Member findMember = findMemberOptional.get();

        return new MemberVO(findMember.getEmail(),
                findMember.getUserName(),
                findMember.getPassword(),
                findMember.getRole());
    }
}
