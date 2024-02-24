package com.biblio.bnr.service.impl;


import com.biblio.bnr.service.SecurityService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

  @Override
  public Boolean hasProtectedAccess() {
    return (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")));
  }

}
