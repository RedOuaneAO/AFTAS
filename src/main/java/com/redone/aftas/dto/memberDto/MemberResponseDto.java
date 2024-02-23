package com.redone.aftas.dto.memberDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MemberResponseDto {
    private Integer memberNum;
    private String fullName;
    private String nationality;
    private String identityNumber;
    private String identityDocumentType;
    private String email;
    private String role;

}
