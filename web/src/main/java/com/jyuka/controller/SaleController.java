package com.jyuka.controller;

import com.jyuka.dto.request.SaleHistoryRequest;
import com.jyuka.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    @PostMapping("/create")
    public String insertSellItem(@RequestBody SaleHistoryRequest request){
        return saleService.insertSaleItem(request.toDto());
    }
}
