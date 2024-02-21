package com.redone.aftas.repositories;
import com.redone.aftas.models.Authority;
import com.redone.aftas.models.enums.AuthorityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Optional<Authority> findByAuthority(AuthorityType authorityType);
}
