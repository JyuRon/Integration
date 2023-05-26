package com.jyuka.dto;

import com.jyuka.board.domain.Party;
import com.jyuka.board.domain.UserAccount;

import java.util.List;

public record PartyWithMemberDto(
        String partyName,
        List<PartyMemberDto> partyMemberDtoList,
        Boolean rewardOrderUse
) {
    public static PartyWithMemberDto of(String partyName, List<PartyMemberDto> partyMemberDtoList, Boolean rewardOrderUse){
        return new PartyWithMemberDto(partyName, partyMemberDtoList, rewardOrderUse);
    }


    // TODO : view 페이지 구현 후 인증정보 발생 시 변경 필요
    public Party fromParty(UserAccount master){
        return Party.of(
                master,
                partyMemberDtoList.size(),
                1,
                partyName,
                rewardOrderUse
        );
    }


}
