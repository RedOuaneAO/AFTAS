package com.redone.aftas.dto;

import com.redone.aftas.models.Member;
import com.redone.aftas.models.Role;
import com.redone.aftas.models.enums.RoleName;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UpdateRoleRequest {
    private int updatedBy;
    private int memberId;
    private RoleName role;

}
