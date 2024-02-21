package com.redone.aftas.repositories;


import com.redone.aftas.models.Role;
import com.redone.aftas.models.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRole(RoleName roleName);
}
