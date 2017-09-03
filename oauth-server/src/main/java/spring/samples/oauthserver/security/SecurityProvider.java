package spring.samples.oauthserver.security;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import spring.samples.dto.Credentials;

@Slf4j
@Component
public class SecurityProvider implements AuthenticationProvider {

  @Value("${authentication.uri}")
  private String authenticationUri;

  private RestTemplate restTemplate;

  @Autowired
  public SecurityProvider(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public Authentication authenticate(Authentication auth) throws AuthenticationException {
    log.info("Calling service to authenticate user {}", auth.getName());
    try {
      callHttpAuthenticationService(auth);
      return buildAuthenticationToken(auth);
    } catch (RestClientException e) {
      log.error("Error calling service to authenticate", e);
      throw new AuthenticationServiceException("Error in authentication for " + auth.getName());
    }
  }

  private UsernamePasswordAuthenticationToken buildAuthenticationToken(Authentication auth) {
    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));
    return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), authorities);
  }

  private void callHttpAuthenticationService(Authentication auth) throws BadCredentialsException {
    Credentials credentials = new Credentials(auth.getName(), (String) auth.getCredentials());
    ResponseEntity<Void> response = restTemplate.postForEntity(authenticationUri, credentials, Void.class);
    if (!response.getStatusCode().equals(HttpStatus.OK)) {
      throw new BadCredentialsException("Error in authentication for " + auth.getName());
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return true;
  }
}
