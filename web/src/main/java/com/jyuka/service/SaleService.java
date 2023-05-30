package com.jyuka.service;

import com.jyuka.board.domain.Party;
import com.jyuka.board.domain.SalesHistory;
import com.jyuka.board.repository.PartyRepository;
import com.jyuka.board.repository.SaleHistoryRepository;
import com.jyuka.dto.SaleHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleHistoryRepository saleHistoryRepository;
    private final PartyRepository partyRepository;

    @Transactional
    public String insertSaleItem(SaleHistoryDto saleHistoryDto){
        Party party = partyRepository.findById(saleHistoryDto.partyId())
                .orElseThrow(EntityNotFoundException::new);

        SalesHistory salesHistory = SalesHistory.of(
                party,
                saleHistoryDto.itemName(),
                saleHistoryDto.price(),
                saleHistoryDto.fee(),
                saleHistoryDto.saleType()
        );

        saleHistoryRepository.save(salesHistory);

        return "success";
    }


}
