package com.biblio.bnr.service.impl;


import com.biblio.bnr.entity.User;
import com.biblio.bnr.entity.UserFactory;
import com.biblio.bnr.exception.NoUserFoundException;
import com.biblio.bnr.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User aUser = this.userRepository
            .findByUsername(username)
            .orElseThrow(
                    () -> new NoUserFoundException(String.format("No user found with username '%s'.", username)));
    return UserFactory.create(aUser);
  }

}
