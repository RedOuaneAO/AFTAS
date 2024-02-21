package com.redone.aftas.models;

import com.redone.aftas.models.enums.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleName role;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Authority> authorities;
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority().name()))
                .collect(Collectors.toList());
        authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        return authorityList;
    }
}
