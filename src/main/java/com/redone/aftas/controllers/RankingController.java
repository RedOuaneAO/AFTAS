package com.redone.aftas.controllers;

import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.dto.ParticipateInCompetitionDto;
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
    public Ranking addRank(@RequestBody ParticipateInCompetitionDto participateInCompetitionDto){
        return rankingService.addRank(participateInCompetitionDto);
    }
    @GetMapping("Ranks")
    public List<Ranking> getAllRanks(){
        return rankingService.getAllRanks();
    }
//    @GetMapping("Score/{competitionCode}")
//    public List<HuntingResponseDto> getScore(@PathVariable String competitionCode){
//        return rankingService.getScore(competitionCode);
//    }
}
