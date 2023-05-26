package com.jyuka.repository;

import com.jyuka.domain.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccount,String> {
}
