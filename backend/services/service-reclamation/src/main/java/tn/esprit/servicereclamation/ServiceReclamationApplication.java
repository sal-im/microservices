package tn.esprit.servicereclamation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceReclamationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceReclamationApplication.class, args);
	}

}
