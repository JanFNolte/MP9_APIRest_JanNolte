package cat.itb.mp9_apirest_jannoltecampos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*@Configuration
public class ConfiguracioWebAPI {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/fantasyCharacters/**").allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "DELETE").maxAge(3600);
            }
        };
    }
}*/
