package com.redone.aftas.controllers;

import com.redone.aftas.dto.CompetitionRequestDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.services.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CompetitionController {
    private final CompetitionService competitionService;
    @PostMapping("Competition")
    public Competition addCompetition(@RequestBody CompetitionRequestDto competitionRequestDto){
        return competitionService.addCompetition(competitionRequestDto);
    }
    @GetMapping("Competitions")
    public List<Competition> getCompetitions(){
        return competitionService.getCompetitions();
    }
}
