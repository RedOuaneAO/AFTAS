package com.redone.aftas.dto.memberDto;

import com.redone.aftas.models.Member;
import com.redone.aftas.models.enums.IdentityDocumentType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = "Member name cannot be null.")
    @NotBlank(message = "Member name cannot be blank.")
    private String memberName;
    @NotNull(message = "family name cannot be null.")
    @NotBlank(message = "family name cannot be blank.")
    private String familyName;
    @NotNull(message = "nationality cannot be null.")
    @NotBlank(message = "nationality cannot be blank.")
    private String nationality;
    @NotNull(message = "identity number cannot be null.")
    @NotBlank(message = "identity number cannot be blank.")
    private String identityNumber;
    @NotNull(message = "identity document cannot be null")
    private IdentityDocumentType identityDocumentType;



    public Member mapToMemberEntity(){
       return Member.builder()
               .name(memberName)
               .familyName(familyName)
               .nationality(nationality)
               .identityNumber(identityNumber)
               .identityDocument(identityDocumentType)
               .build();
    }
}
