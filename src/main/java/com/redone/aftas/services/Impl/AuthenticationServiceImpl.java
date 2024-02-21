package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.authDto.AuthenticateRequest;
import com.redone.aftas.dto.authDto.AuthenticationResponse;
import com.redone.aftas.dto.authDto.RegisterRequest;
import com.redone.aftas.models.Member;
import com.redone.aftas.services.AuthenticationService;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
//        Role role =roleService.findByRole(RoleType.USER);
//        var user = Member.builder()
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(role)
//                .build();
//        var registredUser = userRepository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .email(registredUser.getEmail())
//                .authorities(user.getRole().getAuthorities())
//                .token(jwtToken).build();
        return null;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        return null;
    }
}
