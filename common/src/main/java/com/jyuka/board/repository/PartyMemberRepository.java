package com.jyuka.board.repository;

import com.jyuka.board.domain.PartyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyMemberRepository extends JpaRepository<PartyMember, Long> {
    List<PartyMember> findByParty_Id(Long partyId);
}
