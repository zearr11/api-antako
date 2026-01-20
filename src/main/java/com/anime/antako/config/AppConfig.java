package com.anime.antako.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    private final String urlJikan;

    public AppConfig(@Value("${api.jikan}") String urlJikan) {
        this.urlJikan = urlJikan;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(urlJikan)
                .build();
    }

}
