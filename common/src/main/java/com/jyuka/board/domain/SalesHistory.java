package com.jyuka.board.domain;

import com.jyuka.board.constant.FeeType;
import com.jyuka.board.constant.SaleType;
import com.jyuka.board.domain.converter.FeeTypeConverter;
import com.jyuka.board.domain.converter.SaleTypeConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@ToString(callSuper = true)
@Getter
@NoArgsConstructor
public class SalesHistory extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Party party;
    private String itemName;
    private BigDecimal price;

    @Convert(converter = FeeTypeConverter.class)
    private FeeType fee;

    @Convert(converter = SaleTypeConverter.class)
    private SaleType saleType;

    public SalesHistory(Party party, String itemName, BigDecimal price, FeeType fee, SaleType saleType) {
        this.party = party;
        this.itemName = itemName;
        this.price = price;
        this.fee = fee;
        this.saleType = saleType;
    }

    public static SalesHistory of(Party party, String itemName, BigDecimal price, FeeType fee, SaleType saleType){
        return new SalesHistory(party, itemName, price, fee, saleType);
    }
}
