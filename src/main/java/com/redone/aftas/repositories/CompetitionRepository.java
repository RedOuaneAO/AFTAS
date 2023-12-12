package com.redone.aftas.repositories;

import com.redone.aftas.models.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
