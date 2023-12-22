package com.redone.aftas.controllers;

import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.dto.ParticipateInCompetitionDto;
import com.redone.aftas.dto.rankingDto.RankingRequestDto;
import com.redone.aftas.dto.rankingDto.RankingResponseDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Ranking;
import com.redone.aftas.services.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class RankingController {
    private final RankingService rankingService;

    @PostMapping("Rank")
    public  List<RankingRequestDto>  addRank(@RequestBody ParticipateInCompetitionDto participateInCompetitionDto){
        return rankingService.addRank(participateInCompetitionDto);
    }
    @GetMapping("Ranks")
    public List<Ranking> getAllRanks(){
        return rankingService.getAllRanks();
    }
    @GetMapping("FindByCompetitionCode")
    public List<RankingResponseDto> findByCompetition(@RequestParam String competitionCode){
        return rankingService.findByCompetition(competitionCode);
    }
    @GetMapping("/Podium")
    public List<Ranking> getPodium(@RequestParam String competitionCode) {
        return rankingService.getPodium(competitionCode);
    }

}
