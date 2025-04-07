package de.aittr.bio_marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Разрешаем запросы с любого источника
        config.addAllowedOrigin("*");
        
        // Или для конкретных доменов:
        // config.addAllowedOrigin("https://farmvibe.netlify.app");
        // config.addAllowedOrigin("http://localhost:5174");
        
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(false); // true если используете куки или авторизацию
        
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
