package com.redone.aftas.repositories;

import com.redone.aftas.models.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {
    boolean existsByDate(LocalDate date);
}
