package com.biblio.bnr.controllers.v1;


import com.biblio.bnr.controllers.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminControllerV1 extends BaseController {

  /**
  This is an example of some different kinds of granular restriction for endpoints. You can use the built-in SPEL expressions
  in @PreAuthorize such as 'hasRole()' to determine if a user has access. However, if you require logic beyond the methods
  Spring provides then you can encapsulate it in a service and register it as a bean to use it within the annotation as
  demonstrated below with 'securityService'.
  **/
  @GetMapping()
  //@PreAuthorize("hasRole('ADMIN')")
  //@PreAuthorize("@securityService.hasProtectedAccess()")
  public ResponseEntity<?> getDaHoney() {
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")));
    return ResponseEntity.ok(":O");
  }

}
