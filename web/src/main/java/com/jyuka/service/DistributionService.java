package com.jyuka.service;

import com.jyuka.board.constant.DistributionType;
import com.jyuka.board.domain.Distribution;
import com.jyuka.board.domain.PartyMember;
import com.jyuka.board.domain.SalesHistory;
import com.jyuka.board.repository.DistributionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DistributionService {

    private final DistributionRepository distributionRepository;
    private final PartyMemberService partyMemberService;

    @Transactional
    public void initDistribution(Long partyId, SalesHistory salesHistory){
        List<PartyMember> membersInParty = partyMemberService.findMembersInParty(partyId);

        membersInParty.forEach(
                member -> {
                    distributionRepository.save(
                            Distribution.of(
                                    salesHistory,
                                    member.getUserAccount(),
                                    // TODO: 사용자가 집적 상태값을 입력 할 수 있도록 수정 필요
                                    DistributionType.NOT_RECEIVED)
                    );
                }
        );
    }
}
