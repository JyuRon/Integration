package com.jyuka.board.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Entity
public class Party extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserAccount partyMaster;
    private int totalMemberCount;
    private int rewardOrder;
    private String partyName;
}
