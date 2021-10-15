package com.example.karyawan;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(KaryawanRepository repository) {
        return args -> {
            log.info("Preloading" + repository.save(new Karyawan("Lala", "Jakarta", "Manager", 1000L, 200L)));
            log.info("Preloading" + repository.save(new Karyawan("Lili", "Bandung", "Analyst", 500L, 100L)));
        };
    }
}
