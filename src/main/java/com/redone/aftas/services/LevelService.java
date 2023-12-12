package com.redone.aftas.services;

import com.redone.aftas.dto.LevelRequestDto;
import com.redone.aftas.models.Level;
import org.springframework.stereotype.Service;

@Service
public interface LevelService {
    Level addLevel(LevelRequestDto levelRequestDto);
}
