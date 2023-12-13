package com.redone.aftas.repositories;

import com.redone.aftas.models.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting ,Integer> {
}
