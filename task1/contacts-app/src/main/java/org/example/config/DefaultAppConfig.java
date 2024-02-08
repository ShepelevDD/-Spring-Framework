package org.example.config;

import org.example.Contact;
import org.example.ContactManager;
import org.springframework.context.annotation.*;

import java.util.HashMap;

@ComponentScan("org.example")
@Configuration
@PropertySource("classpath:application.properties")
public class DefaultAppConfig {
}
