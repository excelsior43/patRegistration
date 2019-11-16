package com.k15t.pat;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.k15t.pat.exceptions.UserAlreadyRegisteredMapper;
import com.k15t.pat.exceptions.UserNotFoundMapper;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;


@Configuration
public class JerseyConfig extends ResourceConfig {

    @Autowired private ApplicationContext applicationContext;

    /**
     * Register components with Jersey
     * Add UserAlreadyRegisteredMapper and UserNotFoundMapper f
     * for global error handling.
     */
    @PostConstruct
    public void registerResourcesAndProviders() {
        applicationContext
        .getBeansWithAnnotation(Path.class)
        .values().forEach(this::register);
        register(UserAlreadyRegisteredMapper.class);
        register(UserNotFoundMapper.class);
    }

}
