package com.jyuka.controller;

import com.jyuka.dto.request.PartyWithMemberRequest;
import com.jyuka.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/party")
public class PartyController {

    private final PartyService partyService;

    //TODO : view 페이지 구현 후 인증정보 추가 필요
    @PostMapping("/create")
    public String createParty(@RequestBody PartyWithMemberRequest request){
        return partyService.createParty(request.toDto());
    }
}
