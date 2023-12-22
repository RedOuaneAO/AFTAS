package com.redone.aftas.controllers;

import com.redone.aftas.dto.LevelRequestDto;
import com.redone.aftas.models.Level;
import com.redone.aftas.services.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LevelController {
    private final LevelService levelService;

    @PostMapping("Level")
    public Level addLevel(@RequestBody LevelRequestDto levelRequestDto){
            return levelService.addLevel(levelRequestDto);
    }
    @GetMapping("Levels")
    public List<Level> getAllLevels(){
        return levelService.getLevels();
    }
}
