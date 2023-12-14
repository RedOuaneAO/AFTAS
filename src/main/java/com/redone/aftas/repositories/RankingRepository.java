package com.redone.aftas.repositories;

import com.redone.aftas.models.Competition;
import com.redone.aftas.models.RankId;
import com.redone.aftas.models.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking , RankId> {


    List<Ranking> findByCompetition(Competition competition);
}
