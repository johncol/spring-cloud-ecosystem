package spring.samples.authenticationprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.samples.authenticationprovider.service.AuthenticationService;
import spring.samples.dto.Credentials;

@Slf4j
@RestController
@RestControllerAdvice
public class AuthenticationController {

  private AuthenticationService authenticationService;

  @Autowired
  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> authenticate(@RequestBody Credentials credentials) {
    log.info("{} attempts to login", credentials.getUsername());
    boolean authenticated = authenticationService.authenticate(credentials);
    return ResponseEntity
        .status(authenticated ? HttpStatus.OK : HttpStatus.UNAUTHORIZED)
        .build();
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> onError(Exception exception) {
    log.error("Error occurred with authentication: {}", exception);
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(exception);
  }

}
