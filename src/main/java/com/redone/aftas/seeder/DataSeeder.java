package com.redone.aftas.seeder;

import com.redone.aftas.models.Authority;
import com.redone.aftas.models.Role;
import com.redone.aftas.models.enums.AuthorityType;
import com.redone.aftas.models.enums.RoleName;
import com.redone.aftas.repositories.AuthorityRepository;
import com.redone.aftas.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    @Override
    public void run(String... args) throws Exception {

        Authority authority1= seedAuthority(AuthorityType.CAN_EDIT);
        Authority authority2= seedAuthority(AuthorityType.CAN_ADD);
        Authority authority3= seedAuthority(AuthorityType.CAN_DELETE);

        seedRole(RoleName.ADMIN , List.of(authority1, authority2, authority3));
        seedRole(RoleName.USER , List.of(authority2,authority3));
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
    private void seedRole(RoleName roleName , List<Authority> authorities){
        Optional<Role> existRole = roleRepository.findByRole(roleName);
        if(existRole.isEmpty()){
            Role role = Role.builder().role(roleName).authorities(authorities).build();
            roleRepository.save(role);
        }
    }
}
