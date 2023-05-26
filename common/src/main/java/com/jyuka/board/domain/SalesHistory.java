package com.jyuka.board.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@ToString(callSuper = true)
@Getter
public class SalesHistory extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Party party;
    private String itemName;
    private BigDecimal price;
    private int fee;
    private String sellStatus;
}
