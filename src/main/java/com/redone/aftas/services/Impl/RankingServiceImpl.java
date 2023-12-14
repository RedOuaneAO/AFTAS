package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.RankingRequestDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Member;
import com.redone.aftas.models.Ranking;
import com.redone.aftas.repositories.CompetitionRepository;
import com.redone.aftas.repositories.MemberRepository;
import com.redone.aftas.repositories.RankingRepository;
import com.redone.aftas.services.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private  final MemberRepository  memberRepository;
    @Override
    public Ranking addRank(RankingRequestDto rankingRequestDto) {
        Competition competition = competitionRepository.findById(rankingRequestDto.getCompetitionCode())
                .orElseThrow(()-> new RuntimeException("There is no Competition with this code : " + rankingRequestDto.getCompetitionCode()));
        Member member = memberRepository.findById(rankingRequestDto.getMemberNum())
                .orElseThrow(()->new RuntimeException("There is no Member With This Number : "  + rankingRequestDto.getMemberNum()));
        Ranking ranking = rankingRequestDto.mapToRankingEntity();
        Optional<Ranking> rankingExist = rankingRepository.findById(ranking.getId());
        if (rankingExist.isPresent()){
            throw  new RuntimeException("This Member { " + member.getNum() +" } is already Registered To This Competition");
        }
        return rankingRepository.save(ranking);
    }

    @Override
    public List<Ranking> getAllRanks() {
        return rankingRepository.findAll();
    }

    @Override
    public List<Ranking> getScore(String competitionCode) {
        return null;
    }
}
