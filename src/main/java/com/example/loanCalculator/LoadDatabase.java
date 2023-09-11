package com.example.loanCalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(ClientRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Client("49002010965", ClientSegmentEnum.DEBT, 0L)));
			log.info("Preloading " + repository.save(new Client("49002010976", ClientSegmentEnum.SEGMENT_1, 100L)));
            log.info("Preloading " + repository.save(new Client("49002010987", ClientSegmentEnum.SEGMENT_2, 300L)));
            log.info("Preloading " + repository.save(new Client("49002010998", ClientSegmentEnum.SEGMENT_3, 1000L)));
		};
	}
}
