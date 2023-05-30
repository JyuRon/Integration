package com.jyuka.dto;

import com.jyuka.board.domain.Party;
import com.jyuka.board.domain.PartyMember;
import com.jyuka.board.domain.UserAccount;

import java.time.LocalDateTime;

public record PartyMemberDto(
        Long id,
        int rewardOrder,
        UserAccountDto userAccountDto,
        PartyDto partyDto,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static PartyMemberDto of(Long id, int rewardOrder, UserAccountDto userAccountDto, PartyDto partyDto,  LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy){
        return new PartyMemberDto(id, rewardOrder, userAccountDto, partyDto, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    // 파티 생성시 유저 아이디가 아닌 닉네임으로 작업을 진행
    public static PartyMemberDto of(String nickName, int rewardOrder){
        return PartyMemberDto.of(null, rewardOrder, UserAccountDto.of(nickName), null, null, null, null, null);
    }

    // TODO : view 페이지 구현 후 인증정보 발생 시 변경 필요
    public PartyMember toEntity(UserAccount userAccount, Party party){
        return PartyMember.of(
                rewardOrder,
                userAccount,
                party
        );
    }
}
