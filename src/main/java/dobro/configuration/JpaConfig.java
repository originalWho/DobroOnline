package dobro.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Artur on 4/18/16.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"dobro.repository"})
public class JpaConfig {
}
