package com.jyuka.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
public class Party extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserAccount partyMaster;
    private int totalMemberCount;
    private int rewardOrder;
    private String partyName;
    private Boolean useFlag;

    public Party(UserAccount partyMaster, int totalMemberCount, int rewardOrder, String partyName, Boolean useFlag) {
        this.partyMaster = partyMaster;
        this.totalMemberCount = totalMemberCount;
        this.rewardOrder = rewardOrder;
        this.partyName = partyName;
        this.useFlag = useFlag;
    }

    public static Party of(UserAccount partyMaster, int totalMemberCount, int rewardOrder, String partyName, Boolean useFlag){
        return new Party(partyMaster, totalMemberCount, rewardOrder, partyName, useFlag);
    }

}
