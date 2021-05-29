package home.chaoyang.webex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbInitializer {
    private static final Logger log = LoggerFactory.getLogger(DbInitializer.class);

    @Bean
    CommandLineRunner initDatabase(DeveloperRepo repository) {

      return args -> {
        log.info("Initialized DB ");
      };
    }
}
