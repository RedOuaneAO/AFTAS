package com.redone.aftas.controllers;

import com.redone.aftas.dto.competitionDto.CompetitionRequestDto;
import com.redone.aftas.dto.competitionDto.CompetitionResponseDto;
import com.redone.aftas.dto.rankingDto.RankingResponseDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Ranking;
import com.redone.aftas.services.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CompetitionController {
    private final CompetitionService competitionService;
    @PostMapping("Competition")
    public CompetitionResponseDto addCompetition(@Valid @RequestBody CompetitionRequestDto competitionRequestDto){
        return competitionService.addCompetition(competitionRequestDto);
    }
    @GetMapping("Competitions")
    public List<CompetitionResponseDto> getCompetitions(){
        return competitionService.getCompetitions();
    }
    @GetMapping("CompetitionsPaginated")
    public List<CompetitionResponseDto> getCompetitionsPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        return competitionService.getCompetitionsPaginated(PageRequest.of(page,size));
    }


}
