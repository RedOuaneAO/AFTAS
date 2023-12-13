package com.redone.aftas.repositories;

import com.redone.aftas.models.RankId;
import com.redone.aftas.models.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking , RankId> {
}
