package org.project.infrastructure.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseConfiguration.class})
@ComponentScan(basePackages = "org.project")
public class ApplicationConfiguration {
}
