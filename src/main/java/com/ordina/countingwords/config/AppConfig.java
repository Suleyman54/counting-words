package com.ordina.countingwords.config;

import com.ordina.countingwords.controller.WordFrequencyController;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        register(WordFrequencyController.class);
    }

}
