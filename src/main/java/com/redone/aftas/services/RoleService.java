package com.redone.aftas.services;

import com.redone.aftas.models.Role;
import com.redone.aftas.models.enums.RoleName;

public interface RoleService {
    Role findByRole(RoleName user);
}
