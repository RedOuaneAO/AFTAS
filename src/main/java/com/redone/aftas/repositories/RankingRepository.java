package com.redone.aftas.repositories;

import com.redone.aftas.models.Competition;
import com.redone.aftas.models.RankId;
import com.redone.aftas.models.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking , RankId> {
    @Query("select r From Ranking r where r.competition.code = ?1 ")
    List<Ranking> findByCompetitionCode(String competitionCode);


    List<Ranking> findByCompetitionOrderByScoreDesc(Competition competition);

    List<Ranking> findTop3ByCompetitionOrderByRank(Competition competition);
}
