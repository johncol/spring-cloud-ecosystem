package spring.samples.authenticationprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthenticationProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationProviderApplication.class, args);
	}
}
