package com.biblio.bnr.service;


import com.biblio.bnr.dto.request.AuthenticationRequest;
import com.biblio.bnr.dto.response.AuthenticationResponse;
import com.biblio.bnr.entity.User;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
    AuthenticationResponse refreshToken(String token);
    User registerUser(AuthenticationRequest authenticationRequest);
}
