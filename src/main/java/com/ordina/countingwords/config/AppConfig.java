package com.ordina.countingwords.config;

import com.ordina.countingwords.controller.WordFrequencyController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        register(WordFrequencyController.class);
    }

}