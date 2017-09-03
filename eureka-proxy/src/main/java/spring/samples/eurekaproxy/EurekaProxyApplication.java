package spring.samples.eurekaproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProxyApplication.class, args);
	}
}
