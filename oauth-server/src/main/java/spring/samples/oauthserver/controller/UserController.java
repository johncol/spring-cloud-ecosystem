package spring.samples.oauthserver.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/user")
  public Principal getUser(Principal principal) {
    return principal;
  }

}
