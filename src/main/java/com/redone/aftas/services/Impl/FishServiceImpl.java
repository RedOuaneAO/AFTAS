package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.fishDto.FishRequestDto;
import com.redone.aftas.dto.fishDto.FishResponseDto;
import com.redone.aftas.models.Fish;
import com.redone.aftas.repositories.FishRepository;
import com.redone.aftas.services.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {
    private final FishRepository fishRepository;
    @Override
    public Fish addFish(FishRequestDto fishRequestDto) {
        return fishRepository.save(fishRequestDto.mapToFishEntity());
    }

    @Override
    public List<FishResponseDto> getAllFishs() {
        return fishRepository.findAll().stream().map(fish -> fish.mapToFishRespDto()).collect(Collectors.toList());
    }
}
