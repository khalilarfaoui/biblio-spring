package com.biblio.bnr.controllers.v1;

import com.biblio.bnr.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import com.biblio.bnr.controllers.BaseController;
import com.biblio.bnr.controllers.IUserController;
import com.biblio.bnr.entity.User;
import com.biblio.bnr.exception.NoUserFoundException;
import com.biblio.bnr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class UserControllerV1 extends BaseController implements IUserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByName(@PathVariable("username") String username) {
        User aUser = userService.getUserByUsername(username).orElseThrow(() -> new NoUserFoundException(username));
        return ResponseEntity.ok(aUser);
    }

    @GetMapping("/user")
    public Authentication getUserInfo(Authentication authentication) {
        return authentication;
    }

    @DeleteMapping("/{users}")
    public void deleteLivre(@PathVariable("users") Long users) {
        userRepository.deleteById(users);
    }
}
