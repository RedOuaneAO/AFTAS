package com.redone.aftas.services;

import com.redone.aftas.dto.authDto.AuthenticateRequest;
import com.redone.aftas.dto.authDto.AuthenticationResponse;
import com.redone.aftas.dto.authDto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticateRequest request);
}
