package com.jyuka.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class PartyMember extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rewardOrder; // 리워드 순번 적용 시 사용

    @ManyToOne
    private UserAccount userAccount;

    @ManyToOne
    private Party party;

    public PartyMember(int rewardOrder, UserAccount userAccount, Party party) {
        this.rewardOrder = rewardOrder;
        this.userAccount = userAccount;
        this.party = party;
    }

    public static PartyMember of(int rewardOrder, UserAccount userAccount, Party party){
        return new PartyMember(rewardOrder, userAccount, party);
    }

}
