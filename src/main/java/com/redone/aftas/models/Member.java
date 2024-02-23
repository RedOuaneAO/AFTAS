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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;
    private String name;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private String identityNumber;

    private String email;
    private String password;
    @ManyToOne
    private Role role;

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
                .email(email)
                .nationality(nationality)
                .identityNumber(identityNumber)
                .identityDocumentType(identityDocument != null ? identityDocument.name() : null)
                .role(role.getRole().name())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
