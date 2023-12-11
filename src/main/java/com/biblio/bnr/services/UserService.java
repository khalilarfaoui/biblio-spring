package com.biblio.bnr.services;

import com.biblio.bnr.entity.User;
import com.biblio.bnr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> retrieveUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User retrieveUserByUsername(String username) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> retrieveUserById(long idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id);
    }
}
