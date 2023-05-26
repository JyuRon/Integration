package com.jyuka.dto.request;

import com.jyuka.dto.PartyWithMemberDto;

import java.util.List;
import java.util.stream.Collectors;

public record PartyWithMemberRequest(
        String partyName,
        List<PartyMemberRequest> partyMemberRequest,
        Boolean rewardOrderUse
) {
    public static PartyWithMemberRequest of(
            String partyName,
            List<PartyMemberRequest> partyMemberRequest,
            Boolean rewardOrderUse
    ){
        return new PartyWithMemberRequest(partyName, partyMemberRequest, rewardOrderUse);
    }

    public PartyWithMemberDto toDto(){
        return PartyWithMemberDto.of(
                partyName,
                partyMemberRequest.stream().map(PartyMemberRequest::toDto).collect(Collectors.toList()),
                rewardOrderUse
        );
    }


}
