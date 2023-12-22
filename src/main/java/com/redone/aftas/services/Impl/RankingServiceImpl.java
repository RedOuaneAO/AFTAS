package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.dto.ParticipateInCompetitionDto;
import com.redone.aftas.dto.rankingDto.RankingRequestDto;
import com.redone.aftas.dto.rankingDto.RankingResponseDto;
import com.redone.aftas.models.*;
import com.redone.aftas.repositories.*;
import com.redone.aftas.services.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
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
public List<RankingRequestDto> addRank(ParticipateInCompetitionDto participateInCompetitionDto) {
    Competition competition = competitionRepository.findById(participateInCompetitionDto.getCompetitionCode())
            .orElseThrow(()-> new RuntimeException("There is no Competition with this code : " + participateInCompetitionDto.getCompetitionCode()));
    for (Integer memberNum:participateInCompetitionDto.getMemberNum()) {
        Member member = memberRepository.findById(memberNum)
                .orElseThrow(()->new RuntimeException("There is no Member With This Number : "  + participateInCompetitionDto.getMemberNum()));
    }
    checkCompetitionDateIsNotOver(competition);
    List<Ranking> rankings = participateInCompetitionDto.mapToRankingEntity2();
    List<Ranking> rankings1 =new ArrayList<>();
    for (Ranking rank:rankings) {
        Optional<Ranking> rankingExist = rankingRepository.findById(rank.getId());
        if (rankingExist.isPresent()){
            throw  new RuntimeException("This Member { " + rank.getMember().getNum() +" } is already Registered To This Competition");
        }
        rank.setScore(0);
        rank.setRank(0);
        rankingRepository.save(rank);
        rankings1.add(rank);
    }
    return rankings1.stream().map(ranking -> ranking.mapToReqDto()).collect(Collectors.toList());
}

    public void updateRankingOrder(Competition competition) {
        List<Ranking> ranks = rankingRepository.findByCompetitionOrderByScoreDesc(competition);
        for (int i = 0; i < ranks.size(); i++) {
            Ranking rank = ranks.get(i);
            rank.setRank(i + 1);
            rankingRepository.save(rank);
        }
    }
    public List<Ranking> getPodium(String competitionCode) {
    Competition competition1 =competitionRepository.findById(competitionCode).orElseThrow(()->new RuntimeException("this competition not exist"));
        return rankingRepository.findTop3ByCompetitionOrderByRank(competition1);
    }
    @Override
    public List<Ranking> getAllRanks() {
        return rankingRepository.findAll();
    }

    @Override
    public List<RankingResponseDto> findByCompetition(String competitionCode) {
        updateRankingOrder(Competition.builder().code(competitionCode).build());
        List<Ranking> rankings = rankingRepository.findByCompetitionCode(competitionCode);
        Collections.sort(rankings, (r1, r2) -> Integer.compare(r1.getRank(), r2.getRank()));
        return rankings.stream().map(ranking -> ranking.mapToRespDto()).collect(Collectors.toList());
    }
    public void checkCompetitionDateIsNotOver(Competition competition) {
        LocalDateTime dateTimeOfCompetition = LocalDateTime.of(competition.getDate(),competition.getStartTime());
        if (LocalDateTime.now().isAfter(dateTimeOfCompetition.minus(Period.ofDays(1)))) {
            throw new RuntimeException("You can register in a competition only before 24h of its starting date");
        }
    }
}
