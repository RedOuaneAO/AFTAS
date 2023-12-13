package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.RankingRequestDto;
import com.redone.aftas.models.Ranking;
import com.redone.aftas.repositories.RankingRepository;
import com.redone.aftas.services.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private final RankingRepository rankingRepository;
    @Override
    public Ranking addRank(RankingRequestDto rankingRequestDto) {
        Ranking ranking = rankingRequestDto.mapToRankingEntity();
        return rankingRepository.save(ranking);
    }

    @Override
    public List<Ranking> getAllRanks() {
        return rankingRepository.findAll();
    }
}
