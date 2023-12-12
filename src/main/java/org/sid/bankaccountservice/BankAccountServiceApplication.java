package org.sid.bankaccountservice;

import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.entities.Customer;
import org.sid.bankaccountservice.enums.AccountType;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.sid.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return args -> {
			Stream.of("Mohammed","Rachid","Sara","Hanae").forEach(c->{
				Customer customer=Customer.builder()
						.name(c)
						.build();
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i < 10; i++) {
					BankAccount bankAccount=BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
							.createdAt(new Date())
							.balance(10000+Math.random()*90000)
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountRepository.save(bankAccount);
				}
			});



		};
	}

}