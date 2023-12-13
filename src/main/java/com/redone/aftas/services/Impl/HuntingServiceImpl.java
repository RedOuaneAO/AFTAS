package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.HuntingRequestDto;
import com.redone.aftas.models.Hunting;
import com.redone.aftas.repositories.HuntingRepository;
import com.redone.aftas.services.HuntingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {
    private final HuntingRepository huntingRepository;
    @Override
    public Hunting addHunting(HuntingRequestDto huntingRequestDto) {
        Hunting hunting = huntingRequestDto.mapToHuntingEntity();
        return huntingRepository.save(hunting);
    }
}
