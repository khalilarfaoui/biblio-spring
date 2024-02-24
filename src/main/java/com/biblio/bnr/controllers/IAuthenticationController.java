package com.biblio.bnr.controllers;


import com.biblio.bnr.dto.request.AuthenticationRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/auth")
public interface IAuthenticationController {

    @SecurityRequirements
    @PostMapping()
    ResponseEntity<?> authenticationRequest(@RequestBody @Valid AuthenticationRequest authenticationRequest);
    @GetMapping("/refresh")
    ResponseEntity<?> authenticationRequest(HttpServletRequest request);
    @SecurityRequirements
    @PostMapping("/register")
    ResponseEntity<?> registerUser(@RequestBody @Valid AuthenticationRequest authenticationRequest);
}
