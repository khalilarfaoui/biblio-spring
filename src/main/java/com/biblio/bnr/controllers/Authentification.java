package com.biblio.bnr.controllers;


import com.biblio.bnr.entity.Role;
import com.biblio.bnr.entity.User;
import com.biblio.bnr.payload.MessageResponse;
import com.biblio.bnr.payload.SignupRequest;
import com.biblio.bnr.repositories.RoleRepository;
import com.biblio.bnr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/public/auth")
public class Authentification {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/signup")
    public String heelo(){
        return "hello";
    }
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signUpRequest) {
        System.out.println(signUpRequest.toString());
        if (userRepository.findByUsername(signUpRequest.getUsername()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Erreur: le nom d'utilisateur est déjà pris!"));
        }
        User user = new User(signUpRequest.getUsername(),
              signUpRequest.getPassword());

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName("USER") ;
            roles.add(userRole);
        }else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName("ADMIN");
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName("USER");
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("L'utilisateur s'est enregistré avec succès!"));
    }
}
