package com.redone.aftas.services.Impl;

import com.redone.aftas.models.Role;
import com.redone.aftas.models.enums.RoleName;
import com.redone.aftas.repositories.RoleRepository;
import com.redone.aftas.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findByRole(RoleName roleName) {
        return roleRepository.findByRole(roleName).orElseThrow(()->new RuntimeException("this role doesn't exist"));
    }

}
