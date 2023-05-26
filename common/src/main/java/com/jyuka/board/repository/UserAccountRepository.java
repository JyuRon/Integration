package com.jyuka.board.repository;

import com.jyuka.board.domain.UserAccount;
import com.jyuka.board.repository.projection.UserAccountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = UserAccountProjection.class)
public interface UserAccountRepository extends JpaRepository<UserAccount,String> {
}
