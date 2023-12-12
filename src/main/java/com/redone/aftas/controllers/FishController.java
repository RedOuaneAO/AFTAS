package com.redone.aftas.controllers;

import com.redone.aftas.dto.FishRequestDto;
import com.redone.aftas.models.Fish;
import com.redone.aftas.services.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class FishController {

    private final FishService fishService;

    @PostMapping("Fish")
    public Fish addFish(@RequestBody FishRequestDto fishRequestDto){
        return fishService.addFish(fishRequestDto);
    }
}
