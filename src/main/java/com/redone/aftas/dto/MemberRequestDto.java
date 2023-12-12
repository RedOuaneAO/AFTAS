package com.redone.aftas.dto;

import com.redone.aftas.models.Member;
import com.redone.aftas.models.enums.IdentityDocumentType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MemberRequestDto {

    private Integer num;
    @NotNull
    private String memberName;
    @NotNull
    private String familyName;
    private String nationality;
    @NotNull
    private String identityNumber;
    @NotNull
    private IdentityDocumentType identityDocumentType;



    public Member mapToMemberEntity(){
       return Member.builder()
               .num(num)
               .name(memberName)
               .familyName(familyName)
               .nationality(nationality)
               .identityNumber(identityNumber)
               .identityDocument(identityDocumentType)
               .build();
    }
}
