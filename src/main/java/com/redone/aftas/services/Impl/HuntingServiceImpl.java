package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.huntingDto.HuntingRequestDto;
import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.models.*;
import com.redone.aftas.repositories.*;
import com.redone.aftas.services.HuntingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {
    private final HuntingRepository huntingRepository;
    private final MemberRepository memberRepository;
    private final CompetitionRepository competitionRepository;
    private final RankingRepository rankingRepository;
    private final FishRepository fishRepository;
    @Override
    public HuntingResponseDto addHunting(HuntingRequestDto huntingRequestDto) {
        Member member = memberRepository.findById(huntingRequestDto.getMemberNum())
                .orElseThrow(()->new RuntimeException("This Member Doesn't Exist "));
        Competition competition = competitionRepository.findById(huntingRequestDto.getCompetitionCode())
                .orElseThrow(()->new RuntimeException("There is no Competition With This Code"));
        Ranking ranking =rankingRepository.findById(RankId.builder().memberNum(member.getNum()).competitionCode(competition.getCode()).build())
                .orElseThrow(()->new RuntimeException("This Member are Not Registred To This Competition"));
        Fish fish = fishRepository.findById(huntingRequestDto.getFishName())
                .orElseThrow(()->new RuntimeException("This Fish Are Not Registred"));
        if (huntingRequestDto.getFishWeight()< fish.getAverageWeight()){
            throw new RuntimeException("Your fish's weight is below average");
        }
        Optional<Hunting> HuntingExist = huntingRepository.findByCompetitionAndMemberAndFish(competition,member,fish);
        if(HuntingExist.isPresent()){
            Hunting oldHunting =HuntingExist.get();
            oldHunting.setNumberOfFish(oldHunting.getNumberOfFish()+1);
            Hunting savedHanting = huntingRepository.save(oldHunting);
            Integer score = addScore(competition,member);
            ranking.setScore(score);
            rankingRepository.save(ranking);
            return savedHanting.mapToResponseDto();
        }else {
            Hunting hunting = huntingRequestDto.mapToHuntingEntity();
            hunting.setNumberOfFish(1);
            hunting.setFish(fish);
            Hunting savedHanting = huntingRepository.save(hunting);
            Integer score = addScore(competition,member);
            ranking.setScore(score);
            rankingRepository.save(ranking);
            return savedHanting.mapToResponseDto();
        }
    }

    public Integer addScore(Competition competition , Member member) {
        Integer score =0;
        List<HuntingResponseDto> huntings = huntingRepository.findByCompetitionAndMember(competition , member)
                .stream().map(hunting -> hunting.mapToResponseDto())
                .collect(Collectors.toList());
        for (HuntingResponseDto hunting:huntings) {
            score += hunting.getFish().getLevel().getPoints() * hunting.getNumberOfFish() ;
        }
        return score;
    }
}
