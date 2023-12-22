package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.LevelRequestDto;
import com.redone.aftas.models.Level;
import com.redone.aftas.repositories.LevelRepository;
import com.redone.aftas.services.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    @Override
    public Level addLevel(LevelRequestDto levelRequestDto) {
        Level level =levelRequestDto.mapToLevelEntity();
        return levelRepository.save(level);
    }

    @Override
    public List<Level> getLevels() {
        return levelRepository.findAll();
    }
}
