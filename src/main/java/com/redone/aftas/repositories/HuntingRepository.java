package com.redone.aftas.repositories;

import com.redone.aftas.dto.huntingDto.HuntingResponseDto;
import com.redone.aftas.models.Competition;
import com.redone.aftas.models.Fish;
import com.redone.aftas.models.Hunting;
import com.redone.aftas.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting ,Integer> {

    Optional<Hunting> findByCompetitionAndMemberAndFish(Competition competition, Member member, Fish fish);

    List<Hunting> findByCompetition(Competition competition);

    List<Hunting> findByCompetitionAndMember(Competition competition, Member member);
}
