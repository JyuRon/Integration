package com.jyuka.dto.request;

import com.jyuka.dto.SaleHistoryDto;

import java.math.BigDecimal;

public record SaleHistoryRequest(
        Long partyId,
        String itemName,
        BigDecimal price,
        String fee,
        String saleType
) {
    public static SaleHistoryRequest of(Long partyId, String itemName, BigDecimal price, String fee, String saleType){
        return new SaleHistoryRequest(partyId, itemName, price, fee, saleType);
    }

    public SaleHistoryDto toDto(){
        return SaleHistoryDto.of(
                null,
                partyId,
                itemName,
                price,
                fee,
                saleType
        );
    }

}
