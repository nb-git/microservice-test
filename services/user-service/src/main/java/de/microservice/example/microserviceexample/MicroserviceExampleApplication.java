package de.microservice.example.microserviceexample;

import de.microservice.example.microserviceexample.user.User;
import de.microservice.example.microserviceexample.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class MicroserviceExampleApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User(1L, "Timtest1", "Testuser", "Tim", "tim@test.de", LocalDate.of(1987, 5, 2)));
            userRepository.save(new User(2L, "tinaTest", "Testuser", "Tina", "tina@test.de", LocalDate.of(1978, 2, 5)));
            userRepository.save(new User(3L, "hansentest", "Hansen", "Hans", "hans@test.de", LocalDate.of(1954, 12, 31)));
            userRepository.save(new User(4L, "Caro8775", "Maier", "Carolina", "carolina@testuser.de", LocalDate.of(1975, 6, 4)));
            userRepository.save(new User(5L, "rdump22", "Dump", "Ronald", "ronald@testuser.de", LocalDate.of(1944, 6, 22)));
        };
    }
}
