package com.jyuka.service;

import com.jyuka.board.domain.Party;
import com.jyuka.board.domain.UserAccount;
import com.jyuka.board.repository.PartyMemberRepository;
import com.jyuka.board.repository.PartyRepository;
import com.jyuka.board.repository.UserAccountRepository;
import com.jyuka.dto.PartyWithMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PartyService {

    private final PartyRepository partyRepository;
    private final UserAccountRepository userAccountRepository;
    private final PartyMemberService partyMemberService;

    @Transactional
    public String createParty(PartyWithMemberDto dto){
        // TODO: view 페이지 구현시 인증 정보 컨트롤러에서 받아서 구현
        UserAccount master = userAccountRepository.findById("jyuka")
                .orElseThrow(EntityNotFoundException::new);

        // 파티 정보를 생성
        Party savedParty = partyRepository.save(dto.fromParty(master));

        // 닉네임을 기준으로 기존 회원인지 판별, 존재하지 않는 회원이면 임시 아이디를 생성하여 파티원 정보 입력
        dto.partyMemberDtoList().forEach(
                partyMemberDto -> partyMemberService.insertMemberInParty(partyMemberDto, savedParty)
        );

        return "success";
    }



}
