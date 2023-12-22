package com.redone.aftas.controllers;

import com.redone.aftas.dto.huntingDto.HuntingRequestDto;
import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.models.Hunting;
import com.redone.aftas.services.HuntingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class HuntingController {
    private final HuntingService huntingService;
    @PostMapping("Hunt")
    public HuntingResponseDto addHunting(@RequestBody HuntingRequestDto huntingRequestDto){
        return huntingService.addHunting(huntingRequestDto);
    }
    @GetMapping("MemberHunt")
    public List<HuntingResponseDto> getMemberHunt(@RequestParam String competitionCode ,Integer memberNum){
        return huntingService.getMemberHunt(competitionCode,memberNum);
    }
}
