package com.onlinestore.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * The type App configuration.
 */
@Configuration
@ComponentScan(basePackages = "com.onlinestore")
@Import({WebConfiguration.class,
        DatabaseConfiguration.class,
        MessagesConfiguration.class,
        SecurityConfiguration.class,
        SwaggerConfiguration.class})
public class AppConfiguration {
}
