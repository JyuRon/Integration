package com.jyuka.board.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString(callSuper = true)
@Getter
public class PartyMember extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rewardOrder; // 리워드 순번 적용 시 사용

    @ManyToOne
    private UserAccount userAccount;

    @ManyToOne
    private Party party;
}
