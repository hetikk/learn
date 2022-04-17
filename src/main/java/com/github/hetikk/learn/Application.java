package com.github.hetikk.learn;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log4j2
public class Application {

    @Value("${server.port}")
    private String port;

    @Value("${springdoc.api-docs.path:/v3/api-docs}")
    private String apiUrl;

    @Value("${springdoc.swagger-ui:/swagger-ui/index.html}")
    private String uiUrl;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            log.info("Swagger API URL: http://localhost:{}{}", port, apiUrl);
            log.info("Swagger UI URL: http://localhost:{}{}", port, uiUrl);
        };
    }

}
