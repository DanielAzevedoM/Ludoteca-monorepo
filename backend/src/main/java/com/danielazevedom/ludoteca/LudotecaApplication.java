package com.danielazevedom.ludoteca;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LudotecaApplication {
    public static void main(String[] args) {
        // Carrega variáveis do .env para propriedades do sistema
        Dotenv dotenv = Dotenv.configure()
                              .ignoreIfMissing()
                              .load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));

        SpringApplication.run(LudotecaApplication.class, args);
    }
}
