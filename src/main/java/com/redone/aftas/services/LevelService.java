package com.redone.aftas.services;

import com.redone.aftas.dto.LevelRequestDto;
import com.redone.aftas.models.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LevelService {
    Level addLevel(LevelRequestDto levelRequestDto);

    List<Level> getLevels();
}
