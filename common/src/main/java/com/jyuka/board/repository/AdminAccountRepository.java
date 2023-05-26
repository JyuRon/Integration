package com.jyuka.board.repository;

import com.jyuka.board.domain.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccount,String> {
}
