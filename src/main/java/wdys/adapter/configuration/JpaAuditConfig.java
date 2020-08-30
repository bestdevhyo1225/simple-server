package wdys.adapter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "defaultAuditorAware")
public class JpaAuditConfig {

    @Bean
    public AuditorAware<String> defaultAuditorAware(){
        return () -> Optional.of("default");
    }

}
