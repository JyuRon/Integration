package com.jyuka.dto;

import com.jyuka.board.constant.FeeType;
import com.jyuka.board.constant.SaleType;
import com.jyuka.board.domain.SalesHistory;

import java.math.BigDecimal;

public record SaleHistoryDto(
    Long id,
    Long partyId,
    String itemName,
    BigDecimal price,
    FeeType fee,
    SaleType saleType
) {
    public static SaleHistoryDto of(
            Long id,
            Long partyId,
            String itemName,
            BigDecimal price,
            String fee,
            String saleType
    ){
        return new SaleHistoryDto(id, partyId, itemName, price, FeeType.valueOf(fee), SaleType.valueOf(saleType));
    }

    public static SaleHistoryDto from(SalesHistory salesHistory){
        return SaleHistoryDto.of(
                salesHistory.getId(),
                salesHistory.getParty().getId(),
                salesHistory.getItemName(),
                salesHistory.getPrice(),
                salesHistory.getFee().getFeeName(),
                salesHistory.getSaleType().getName()
        );
    }


}
