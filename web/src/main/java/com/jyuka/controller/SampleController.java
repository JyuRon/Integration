package com.jyuka.controller;

import com.jyuka.domain.Member;
import com.jyuka.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class SampleController {

    private final SampleService sampleService;

    @PostMapping
    public Member insertMember(@RequestBody Member member){
        return sampleService.insertMember(member);
    }
}
