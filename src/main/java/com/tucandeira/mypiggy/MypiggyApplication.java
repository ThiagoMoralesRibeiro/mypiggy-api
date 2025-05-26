package com.tucandeira.mypiggy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tucandeira.mypiggy")
@EnableJpaRepositories(basePackages = {
    "com.tucandeira.mypiggy.user.infrastructure.repository"
    // inclua outros pacotes de repositórios se houver
})
public class MypiggyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MypiggyApplication.class, args);
    }
}

