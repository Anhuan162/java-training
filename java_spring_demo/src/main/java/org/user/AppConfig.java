package org.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.user") // Quét package để tìm @Component
public class AppConfig {
}
