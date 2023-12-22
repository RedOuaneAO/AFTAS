package com.redone.aftas.repositories;

import com.redone.aftas.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByIdentityNumber(String identityNumber);
}
