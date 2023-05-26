package com.jyuka.dto;

import com.jyuka.board.domain.Party;

import java.time.LocalDateTime;

public record PartyDto (
        Long id,
        UserAccountDto partyMaster,
        int totalMemberCount,
        int rewardOrder,
        String partyName,
        Boolean useFlag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy

) {
    public static PartyDto of(
            Long id,
            UserAccountDto partyMaster,
            int totalMemberCount,
            int rewardOrder,
            String partyName,
            Boolean useFlag,
            LocalDateTime createdAt,
            String createdBy,
            LocalDateTime modifiedAt,
            String modifiedBy
    ){
        return new PartyDto(id, partyMaster, totalMemberCount, rewardOrder, partyName, useFlag, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static PartyDto from(Party party) {
        return PartyDto.of(
                party.getId(),
                UserAccountDto.from(party.getPartyMaster()),
                party.getTotalMemberCount(),
                party.getRewardOrder(),
                party.getPartyName(),
                party.getUseFlag(),
                party.getCreatedAt(),
                party.getCreatedBy(),
                party.getModifiedAt(),
                party.getModifiedBy()
        );
    }
}
