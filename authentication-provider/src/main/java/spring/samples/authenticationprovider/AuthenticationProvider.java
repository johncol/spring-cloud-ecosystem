package spring.samples.authenticationprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthenticationProvider {

  public static void main(String[] args) {
    SpringApplication.run(AuthenticationProvider.class, args);
  }
}
