package ru.netology.conditionalapp.config;

import ru.netology.conditionalapp.profiles.DevProfile;
import ru.netology.conditionalapp.profiles.ProductionProfile;
import ru.netology.conditionalapp.profiles.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(
            name = "netology.profile.dev",
            havingValue = "true",
            matchIfMissing = true // <-- ВАЖНО: профиль по умолчанию
    )
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(
            name = "netology.profile.dev",
            havingValue = "false"
    )
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}