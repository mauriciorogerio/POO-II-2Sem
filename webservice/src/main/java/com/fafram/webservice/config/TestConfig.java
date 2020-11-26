package com.fafram.webservice.config;

import com.fafram.webservice.entities.Customer;
import com.fafram.webservice.entities.Phone;
import com.fafram.webservice.repositories.CustomerRepository;
import com.fafram.webservice.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void run(String... args) throws Exception {

        Phone num1 = new Phone(null,"telefone",12121212);
        Phone num2 = new Phone(null,"telefone",23232323);
        Phone num3 = new Phone(null,"telefone",34343434);
        Phone num4 = new Phone(null,"telefone",45454545);



        phoneRepository.saveAll(Arrays.asList(num1,num2,num3,num4));

        Customer user1 = new Customer(null,"Mauricio","mauricio@gmail","123456");
        Customer user2 = new Customer(null,"Fulano","fulano@gmail","789101112");
        Customer user3 = new Customer(null,"Ciclano","ciclano@123","13141516");
        Customer user4 = new Customer(null,"Beutrano","beutrano@123","17181920");

        user1.getPhones().add(num1);
        user2.getPhones().add(num2);
        user3.getPhones().add(num3);
        user4.getPhones().add(num4);

        customerRepository.saveAll(Arrays.asList(user1, user2,user3,user4));

    }
}
