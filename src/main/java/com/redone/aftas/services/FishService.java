package com.redone.aftas.services;

import com.redone.aftas.dto.FishRequestDto;
import com.redone.aftas.models.Fish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FishService {
    Fish addFish(FishRequestDto fishRequestDto);

    List<Fish> getAllFishs();
}
