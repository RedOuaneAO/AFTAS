package com.redone.aftas.services.Impl;

import com.redone.aftas.dto.authDto.AuthenticateRequest;
import com.redone.aftas.dto.authDto.AuthenticationResponse;
import com.redone.aftas.dto.authDto.RegisterRequest;
import com.redone.aftas.models.Member;
import com.redone.aftas.models.Role;
import com.redone.aftas.models.enums.RoleName;
import com.redone.aftas.services.AuthenticationService;
import com.redone.aftas.services.JwtService;
import com.redone.aftas.services.MemberService;
import com.redone.aftas.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;
    private final JwtService jwtService;
    private  final RoleService roleService;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Role role =roleService.findByRole(RoleName.USER);
        var user =Member.builder()
               .accessionDate(new Date())
               .name(request.getFirstName())
               .familyName(request.getLastName())
               .identityNumber(request.getIdentityNumber())
               .nationality(request.getNationality())
               .identityDocument(request.getIdentityDocumentType())
               .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
               .role(role)
               .build();
        var registredUser = memberService.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .email(registredUser.getEmail())
                .authorities(user.getRole().getAuthorities())
                .token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        return null;
    }
}
