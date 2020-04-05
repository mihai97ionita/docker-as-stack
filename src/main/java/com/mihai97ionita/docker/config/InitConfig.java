package com.mihai97ionita.docker.config;

import com.mihai97ionita.docker.model.Shop;
import com.mihai97ionita.docker.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class InitConfig {

    @Autowired
    private Repository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void init()
    {
        log.info("Baza de date initializata");
        repository.save(Shop.builder().id(1L).name("Brad").price("100").build());
        repository.save(Shop.builder().id(2L).name("Gloabe").price("30").build());
        repository.save(Shop.builder().id(3L).name("Beteala").price("50").build());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
