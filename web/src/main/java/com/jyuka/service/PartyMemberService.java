package com.jyuka.service;

import com.jyuka.board.domain.Party;
import com.jyuka.board.domain.PartyMember;
import com.jyuka.board.domain.UserAccount;
import com.jyuka.board.repository.PartyMemberRepository;
import com.jyuka.board.repository.UserAccountRepository;
import com.jyuka.dto.PartyMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PartyMemberService {

    private final PartyMemberRepository partyMemberRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAccountRepository userAccountRepository;

    @Transactional
    public void insertMemberInParty(PartyMemberDto dto, Party party){
        String nickName = dto.userAccountDto().nickname();
        String dummyId = "tmp_" + nickName;
        String dummyPassword = passwordEncoder.encode("{bcrypt}" + UUID.randomUUID());
        UserAccount userAccount = userAccountRepository.findByNickname(nickName)
                // 유니크키인 닉네임으로 유저 검색시 존재하지 않으면 임시 아이디를 생성한다.
                .orElseGet(() -> userAccountRepository.save(
                                UserAccount.of(dummyId, dummyPassword, null, nickName, null)
                        )
                );
        partyMemberRepository.save(dto.toEntity(userAccount, party));
    }

    public List<PartyMember> findMembersInParty(Long partyId){
        return partyMemberRepository.findByParty_Id(partyId);
    }
}
