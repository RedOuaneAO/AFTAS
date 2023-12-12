package com.redone.aftas.repositories;

import com.redone.aftas.models.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Long> {
}
