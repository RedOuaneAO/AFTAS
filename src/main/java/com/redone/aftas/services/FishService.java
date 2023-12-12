package com.redone.aftas.services;

import com.redone.aftas.dto.FishRequestDto;
import com.redone.aftas.models.Fish;
import org.springframework.stereotype.Service;

@Service
public interface FishService {
    Fish addFish(FishRequestDto fishRequestDto);
}
