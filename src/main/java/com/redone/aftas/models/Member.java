package com.redone.aftas.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Integer num;
    private String name;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private String identityNumber;
    private IdentityDocumentType identityDocument;
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Ranking> rankings;
    @OneToMany(mappedBy = "member" , fetch = FetchType.LAZY)
    private List<Hunting> huntingList;
}
