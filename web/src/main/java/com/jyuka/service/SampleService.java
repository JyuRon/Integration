package com.jyuka.service;

import com.jyuka.domain.Member;
import com.jyuka.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final MemberRepository memberRepository;

    public Member insertMember(Member member){
        return memberRepository.save(member);
    }
}

