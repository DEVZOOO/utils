package com.judy.utils.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger config
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        String springDocVersion = "v0.0.1";
        Info info = new Info()
            .title("RAIN ALERT REST API")
            .version(springDocVersion)
            .description("REST API for RAIN ALERT")
            .contact(new Contact().name("Judy").url("https://github.com/DEVZOOO/rain_alert").email("devzoou@gmail.com"))
            ;

        return new OpenAPI()
            .info(info)
            .addServersItem(new Server().url("/"))
            ;
    }
}
