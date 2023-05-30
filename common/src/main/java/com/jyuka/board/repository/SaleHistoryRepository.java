package com.jyuka.board.repository;

import com.jyuka.board.domain.SalesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleHistoryRepository extends JpaRepository<SalesHistory, Long> {
}
