package com.biblio.bnr.services;


import com.biblio.bnr.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> retrieveUsers();
    User updateUser (User user);
    User addUser(User user);
    Optional<User> retrieveUserById (long idUser);

    void deleteUser(long id);
}
