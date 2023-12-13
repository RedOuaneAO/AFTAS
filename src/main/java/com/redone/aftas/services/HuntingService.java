package com.redone.aftas.services;

import com.redone.aftas.dto.HuntingRequestDto;
import com.redone.aftas.models.Hunting;
import org.springframework.stereotype.Service;

@Service
public interface HuntingService {
    Hunting addHunting(HuntingRequestDto huntingRequestDto);
}
