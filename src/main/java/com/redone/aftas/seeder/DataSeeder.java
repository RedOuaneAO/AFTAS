package com.redone.aftas.seeder;

import com.redone.aftas.models.Authority;
import com.redone.aftas.models.Member;
import com.redone.aftas.models.Role;
import com.redone.aftas.models.enums.AuthorityType;
import com.redone.aftas.models.enums.RoleName;
import com.redone.aftas.repositories.AuthorityRepository;
import com.redone.aftas.repositories.MemberRepository;
import com.redone.aftas.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

        Authority authority1= seedAuthority(AuthorityType.CAN_ADD);
        Authority authority2= seedAuthority(AuthorityType.CAN_EDIT);
        Authority authority3= seedAuthority(AuthorityType.CAN_DELETE);
        Authority authority4= seedAuthority(AuthorityType.CAN_VIEW);

        Role supAdminRole = seedRole(RoleName.SUPER_ADMIN , List.of(authority1, authority2, authority3, authority4));
        seedRole(RoleName.ADMIN , List.of(authority1, authority2,authority4));
        seedRole(RoleName.USER , List.of(authority4));

        seedSuperAdmin(supAdminRole);
    }
    private Authority seedAuthority(AuthorityType authorityType){
        Optional<Authority> existAuthority = authorityRepository.findByAuthority(authorityType);
        if(existAuthority.isEmpty()){
             Authority authority = Authority.builder().authority(authorityType).build();
             authorityRepository.save(authority);
             return authority;
        }
        return existAuthority.get();
    }
    private Role seedRole(RoleName roleName , List<Authority> authorities){
        Optional<Role> existRole = roleRepository.findByRole(roleName);
        if(existRole.isEmpty()){
            Role role = Role.builder().role(roleName).authorities(authorities).build();
            return  roleRepository.save(role);
        }
        return null;
    }
    private void seedSuperAdmin(Role role){
        Member member =Member.builder()
                .email("superAdmin@gmail.com")
                .password(passwordEncoder.encode("12345"))
                .role(role)
                .build();
        memberRepository.save(member);
    }
}
