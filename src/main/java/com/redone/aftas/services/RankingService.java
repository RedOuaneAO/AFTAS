package com.redone.aftas.services;

import com.redone.aftas.dto.RankingRequestDto;
import com.redone.aftas.models.Ranking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RankingService {
    Ranking addRank(RankingRequestDto rankingRequestDto);

    List<Ranking> getAllRanks();

    List<Ranking> getScore(String competitionCode);
}
