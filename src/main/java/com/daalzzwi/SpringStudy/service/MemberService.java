package com.daalzzwi.SpringStudy.service;

import com.daalzzwi.SpringStudy.domain.Member;
import com.daalzzwi.SpringStudy.repository.MemberRepository;
import com.daalzzwi.SpringStudy.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = new MemoryMemberRepository();
    }

    /**ss
     * 회원가입
     */
    
    public Long join(Member member) {

        // ctrl + shift + t = 테스트 코드 자동 추가
        // ctrl + alt + m = 메서드 추출 하기
        // ctrl + alt + v = 변수 자동 생성 단축키
        // ctrl + shift + enter = ;자동 생성 및 다음 행으로 이동 단축키
        // Optional<Member> result = memberRepository.findByName(member.getName());

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {

        return memberRepository.findById(memberId);
    }
}
