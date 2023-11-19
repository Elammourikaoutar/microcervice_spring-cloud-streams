package ma.enset.consumerservice;

import ma.enset.consumerservice.entities.Customer;
import ma.enset.consumerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.UUID;


@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(ConfigParams.class)
public class ConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args ->{
			customerRepository.save(Customer.builder().id(UUID.randomUUID().toString()).email("kaoutar@gmail.com").name("kaoutar el ammouri").build());
			customerRepository.save(Customer.builder().id(UUID.randomUUID().toString()).email("anas@gmail.com").name("anas thaifa").build());
			customerRepository.save(Customer.builder().id(UUID.randomUUID().toString()).email("meryem@gmail.com").name("meryem bahi").build());
			customerRepository.save(Customer.builder().id(UUID.randomUUID().toString()).email("mohammed@gmail.com").name("mohammed youssfi").build());
		};
	}


}
