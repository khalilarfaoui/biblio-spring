package com.biblio.bnr.service;



import com.biblio.bnr.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> getUserByUsername(String username);
}
