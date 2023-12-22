package com.redone.aftas.controllers;

import com.redone.aftas.dto.fishDto.FishRequestDto;
import com.redone.aftas.dto.fishDto.FishResponseDto;
import com.redone.aftas.models.Fish;
import com.redone.aftas.services.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class FishController {

    private final FishService fishService;

    @PostMapping("Fish")
    public Fish addFish(@RequestBody FishRequestDto fishRequestDto){
        return fishService.addFish(fishRequestDto);
    }
   @GetMapping("Fishs")
    public List<FishResponseDto> GetAllFishs(){
        return fishService.getAllFishs();
    }
}
