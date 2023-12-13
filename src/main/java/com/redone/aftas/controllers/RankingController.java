package com.redone.aftas.controllers;

import com.redone.aftas.dto.RankingRequestDto;
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
    public Ranking addRank(@RequestBody RankingRequestDto rankingRequestDto){
        return rankingService.addRank(rankingRequestDto);
    }
    @GetMapping("Ranks")
    public List<Ranking> getAllRanks(){
        return rankingService.getAllRanks();
    }
}
