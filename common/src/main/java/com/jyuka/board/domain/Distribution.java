package com.jyuka.board.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString(callSuper = true)
public class Distribution extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SalesHistory salesHistory;

    @ManyToOne
    private UserAccount userAccount;

    private String distributionStatus;
}
