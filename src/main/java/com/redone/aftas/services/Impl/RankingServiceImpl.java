package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.dto.ParticipateInCompetitionDto;
import com.redone.aftas.models.*;
import com.redone.aftas.repositories.*;
import com.redone.aftas.services.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private  final MemberRepository  memberRepository;
    private final HuntingRepository huntingRepository;
    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;

    @Override
    public Ranking addRank(ParticipateInCompetitionDto participateInCompetitionDto) {
        Competition competition = competitionRepository.findById(participateInCompetitionDto.getCompetitionCode())
                .orElseThrow(()-> new RuntimeException("There is no Competition with this code : " + participateInCompetitionDto.getCompetitionCode()));
        Member member = memberRepository.findById(participateInCompetitionDto.getMemberNum())
                .orElseThrow(()->new RuntimeException("There is no Member With This Number : "  + participateInCompetitionDto.getMemberNum()));
        Ranking ranking = participateInCompetitionDto.mapToRankingEntity2();
        Optional<Ranking> rankingExist = rankingRepository.findById(ranking.getId());
        if (rankingExist.isPresent()){
            throw  new RuntimeException("This Member { " + member.getNum() +" } is already Registered To This Competition");
        }
        ranking.setScore(0);
        ranking.setRank(0);
        return rankingRepository.save(ranking);
    }

    @Override
    public List<Ranking> getAllRanks() {
        return rankingRepository.findAll();
    }

}
