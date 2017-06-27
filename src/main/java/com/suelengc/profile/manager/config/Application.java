package com.suelengc.profile.manager.config;

import com.suelengc.profile.manager.data.ProfileRepository;
import com.suelengc.profile.manager.model.Profile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.suelengc.profile.manager.controller"})
@EntityScan("com.suelengc.profile.manager.model")
@EnableJpaRepositories("com.suelengc.profile.manager.data")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProfileRepository repository) {
        return (args) -> {
            repository.save(new Profile("Jack", "jack@gmail.com", "123"));
            repository.save(new Profile("Chloe", "chloe@gmail.com", "123"));
            repository.save(new Profile("Kim", "kim@gmail.com", "123"));
            repository.save(new Profile("David", "david@gmail.com", "123"));
            repository.save(new Profile("Michelle", "michelle@gmail.com", "123"));
        };
    }

}
