package com.biblio.bnr.controllers;


import com.biblio.bnr.entity.Role;
import com.biblio.bnr.entity.User;
import com.biblio.bnr.payload.MessageResponse;
import com.biblio.bnr.payload.SignupRequest;
import com.biblio.bnr.repositories.RoleRepository;
import com.biblio.bnr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class Authentification {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @PostMapping("/test")
    public User heelo(@RequestBody SignupRequest signUpRequest) {
        System.out.println(userRepository.findByUsername(signUpRequest.getUsername()));
        return userRepository.findByUsername(signUpRequest.getUsername());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signUpRequest) {
        System.out.println(signUpRequest.getUsername());
        if (false) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Erreur: le nom d'utilisateur est déjà pris!"));
        }
        User user = new User(signUpRequest.getUsername(),
                bCryptPasswordEncoder.encode(signUpRequest.getPassword())
        );

        System.out.println(signUpRequest.getRoles());

        Set<String> strRoles = signUpRequest.getRoles();
        System.out.println("Roles: " + strRoles);
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName("USER");
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ADMIN":
                        Role adminRole = roleRepository.findByName("ADMIN");
                        System.out.println("adminRole: " + adminRole.getName());
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName("USER");
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        System.out.println(user.getRoles());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getUsername());

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("L'utilisateur s'est enregistré avec succès!"));
    }
}
