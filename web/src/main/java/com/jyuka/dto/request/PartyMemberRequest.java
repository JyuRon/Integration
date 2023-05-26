package com.jyuka.dto.request;

import com.jyuka.dto.PartyMemberDto;

public record PartyMemberRequest(
        String nickName,
        int rewardOrder
) {
    public static PartyMemberRequest of(String nickName, int rewardOrder){
        return new PartyMemberRequest(nickName, rewardOrder);
    }

    // 파티 생성 요청시 request -> dto 변환
    public PartyMemberDto toDto(){
        return PartyMemberDto.of(nickName, rewardOrder);
    }
}
