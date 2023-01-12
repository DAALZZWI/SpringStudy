package com.daalzzwi.SpringStudy.service;

import com.daalzzwi.SpringStudy.domain.Member;
import com.daalzzwi.SpringStudy.repository.MemberRepository;
import com.daalzzwi.SpringStudy.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private MemberService memberService;
    private MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {

        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {

        memberRepository.clearStore();
    }

    @Test
    void join() {

        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void joinException() {

        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        Assertions.assertThat(e.getMessage());
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}