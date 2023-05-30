package com.jyuka.board.domain;

import com.jyuka.board.constant.DistributionType;
import com.jyuka.board.domain.converter.DistributionTypeConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Distribution extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SalesHistory salesHistory;

    @ManyToOne
    private UserAccount userAccount;

    @Convert(converter = DistributionTypeConverter.class)
    private DistributionType distributionType;

    public Distribution(SalesHistory salesHistory, UserAccount userAccount, DistributionType distributionType) {
        this.salesHistory = salesHistory;
        this.userAccount = userAccount;
        this.distributionType = distributionType;
    }

    public static Distribution of(SalesHistory salesHistory, UserAccount userAccount, DistributionType distributionType){
        return new Distribution(salesHistory, userAccount, distributionType);
    }
}
