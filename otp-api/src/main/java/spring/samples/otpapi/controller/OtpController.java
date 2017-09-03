package spring.samples.otpapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.samples.dto.OtpRequest;

@Slf4j
@RestController
@RequestMapping("/otp")
public class OtpController {

  @PostMapping
  public ResponseEntity<?> send(OtpRequest request) {
    log.info("Sending OTP");
    return ResponseEntity.ok("OTP was sent");
  }

}
