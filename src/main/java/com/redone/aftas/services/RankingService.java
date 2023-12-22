package com.redone.aftas.services;

import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.dto.ParticipateInCompetitionDto;
import com.redone.aftas.dto.rankingDto.RankingRequestDto;
import com.redone.aftas.dto.rankingDto.RankingResponseDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Ranking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RankingService {
    List<RankingRequestDto>  addRank(ParticipateInCompetitionDto participateInCompetitionDto);

    List<Ranking> getAllRanks();

    List<RankingResponseDto> findByCompetition(String competitionCode);
    List<Ranking> getPodium(String competitionCode);




}
