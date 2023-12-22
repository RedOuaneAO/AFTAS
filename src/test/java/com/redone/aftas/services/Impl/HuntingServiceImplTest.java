package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.huntingDto.HuntingRequestDto;
import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Fish;
import com.redone.aftas.models.Hunting;
import com.redone.aftas.models.Member;
import com.redone.aftas.repositories.*;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class HuntingServiceImplTest {
    private  HuntingServiceImpl huntingService;
    @Mock
    private  HuntingRepository huntingRepository;
    @Mock
    private  CompetitionRepository competitionRepository;
    @Mock
    private  MemberRepository memberRepository;
    @Mock
    private  RankingRepository rankingRepository;
    @Mock
    private  FishRepository fishRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        huntingService = new HuntingServiceImpl( huntingRepository,  memberRepository,  competitionRepository,  rankingRepository,  fishRepository);
    }


    @Test
    void testCreateHuntingWithCompetitionNotExist() {
        HuntingRequestDto hunting= HuntingRequestDto.builder().competitionCode("mar-23-12-23").build();
        Mockito.when(competitionRepository.findById(hunting.getCompetitionCode())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> huntingService.addHunting(hunting));
    }

    @Test
    void testCreateHuntingWithMemberNotExist() {
        HuntingRequestDto hunting= HuntingRequestDto.builder().memberNum(122).build();
        Mockito.when(memberRepository.findById(hunting.getMemberNum())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> huntingService.addHunting(hunting));
    }
}