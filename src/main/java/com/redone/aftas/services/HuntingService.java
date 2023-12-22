package com.redone.aftas.services;

import com.redone.aftas.dto.huntingDto.HuntingRequestDto;
import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.models.Hunting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HuntingService {
    HuntingResponseDto addHunting(HuntingRequestDto huntingRequestDto);


    List<HuntingResponseDto> getMemberHunt(String competitionCode, Integer memberNum);
}
