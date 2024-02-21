package com.redone.aftas.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.redone.aftas.dto.memberDto.MemberRequestDto;
import com.redone.aftas.dto.memberDto.MemberResponseDto;
import com.redone.aftas.models.enums.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;
    private String name;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private String identityNumber;

//    now
    private String email;
    private String password;
//
    private IdentityDocumentType identityDocument;
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Ranking> rankings;
    @OneToMany(mappedBy = "member" , fetch = FetchType.LAZY)
    private List<Hunting> huntingList;


    public MemberResponseDto mepToMRDto(){
        return  MemberResponseDto.builder()
                .memberNum(num)
                .fullName(familyName+" "+name)
                .nationality(nationality)
                .identityNumber(identityNumber)
                .identityDocumentType(identityDocument.name())
                .build();
    }
}
