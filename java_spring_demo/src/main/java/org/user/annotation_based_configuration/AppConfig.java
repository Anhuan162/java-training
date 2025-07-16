package org.user.annotation_based_configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.user.annotation_based_configuration")
public class AppConfig {
}
