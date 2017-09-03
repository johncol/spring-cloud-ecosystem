package spring.samples.authenticationprovider.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import spring.samples.dto.Credentials;

@Service
public class AuthenticationService {

  private static final Map<String, Credentials> allowedUsers;

  static {
    allowedUsers = new HashMap<>();
    allowedUsers.put("john", new Credentials("john", "pass"));
    allowedUsers.put("admin", new Credentials("admin", "admin"));
    allowedUsers.put("user", new Credentials("user", "user"));
  }

  public boolean authenticate(Credentials credentials) {
    Credentials credentialsFound = allowedUsers.get(credentials.getUsername());
    if (credentialsFound != null) {
      return credentialsFound.getPassword().equals(credentials.getPassword());
    }
    return false;
  }

}
