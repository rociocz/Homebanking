package com.app.homebanking;

import com.app.homebanking.models.Client;
import com.app.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	};


	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository) {
		return (args -> {
			Client client1 = new Client();
			client1.setFirstName("Rocío");
			client1.setLastName("Czarnecki");
			client1.setEmail("rociocz@gmail.com");

			Client client2 = new Client("Melba", "Morel", "melba@mindhub.com");

			clientRepository.save(client2);
			clientRepository.save(client1);

		});
	}
}