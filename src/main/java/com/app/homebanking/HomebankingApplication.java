package com.app.homebanking;

import com.app.homebanking.models.Account;
import com.app.homebanking.models.Client;
import com.app.homebanking.repositories.AccountRepository;
import com.app.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository) {
		return (args -> {
			//fecha actual
			LocalDate today = LocalDate.now();
			//PASO 1 - creamos parcialmente dos clientes
			Client client1 = new Client("Melba", "Morel", "melba@mindhub.com");
			Client client2 = new Client("Rocio", "Czarnecki", "rocioczarnecki@gmail.com");
			//PASO 2 - creamos parcialmente cuentas
			Account account1 = new Account("VIN001", today, 5000.70);
			Account account2 = new Account("VIN002", today.plusDays(1), 7500.00);
			Account account3 = new Account("VIN006", today, 325.75);
			Account account4 = new Account("VIN007", today.minusDays(1), 8000.50);

			//PASO 3 - guardo los clientes parciales para que se genera(spring) un id automático
			clientRepository.save(client1);
			clientRepository.save(client2);
			//PASO 4 - una vez obtenido el id podemos agregar las cuentas
			client1.addAccount(account1);
			client1.addAccount(account2);
			client2.addAccount(account3);
			client2.addAccount(account4);
			//PASO 5 - guardamos las cuentas
			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);
			//PASO 6 - por último guardamos nuevamente los clientes con las cuentas
			clientRepository.save(client1);
			clientRepository.save(client2);

		});
	}
}