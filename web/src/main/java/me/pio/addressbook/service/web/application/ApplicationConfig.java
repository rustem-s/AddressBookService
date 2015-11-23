package me.pio.addressbook.service.web.application;


import me.pio.addressbook.service.web.provider.JacksonJsonProvider;
import me.pio.addressbook.service.web.resource.PersonService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses() {

        Set<Class<?>> s = new HashSet<Class<?>>();

        s.add(JacksonJsonProvider.class);
        s.add(PersonService.class);

        return s;
    }
}