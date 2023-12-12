package com.redone.aftas.controllers;

import com.redone.aftas.dto.CompetitionRequestDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.services.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CompetitionController {
    private final CompetitionService competitionService;
    @PostMapping("Competition")
    public Competition addCompetition(@RequestBody CompetitionRequestDto competitionRequestDto){
        return competitionService.addCompetition(competitionRequestDto);
    }
}
