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
    private final DistributionService distributionService;

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

        SalesHistory result = saleHistoryRepository.save(salesHistory);

        // 분배 품목 등록시 파티원 해당 품목에 대한 분해 현황 초기화
        distributionService.initDistribution(saleHistoryDto.partyId(), result);


        return "success";
    }


}
