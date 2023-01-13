package com.daalzzwi.SpringStudy.config;

import com.daalzzwi.SpringStudy.repository.MemberRepository;
import com.daalzzwi.SpringStudy.repository.MemoryMemberRepository;
import com.daalzzwi.SpringStudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }
}
