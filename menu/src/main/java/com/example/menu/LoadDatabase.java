package com.example.menu;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MenuRepository repository) {
        return args -> {
            log.info("Preloading" + repository.save(new Menu("Burger", 299L, "https://cdn.auth0.com/blog/whatabyte/burger-sm.png", "Made from 100% fresh beef.")));
            log.info("Preloading" + repository.save(new Menu("Pizza", 599L, "https://cdn.auth0.com/blog/whatabyte/pizza-sm.png", "Totally fresh and natural cheese.")));
        };
    }
}
