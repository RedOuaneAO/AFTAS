package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.fishDto.FishRequestDto;
import com.redone.aftas.models.Fish;
import com.redone.aftas.repositories.FishRepository;
import com.redone.aftas.services.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {
    private final FishRepository fishRepository;
    @Override
    public Fish addFish(FishRequestDto fishRequestDto) {
        return fishRepository.save(fishRequestDto.mapToFishEntity());
    }

    @Override
    public List<Fish> getAllFishs() {
        return fishRepository.findAll();
    }
}
