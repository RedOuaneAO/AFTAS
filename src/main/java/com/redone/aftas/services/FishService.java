package com.redone.aftas.services;

import com.redone.aftas.dto.fishDto.FishRequestDto;
import com.redone.aftas.dto.fishDto.FishResponseDto;
import com.redone.aftas.models.Fish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FishService {
    Fish addFish(FishRequestDto fishRequestDto);

    List<FishResponseDto> getAllFishs();
}
