package com.letsjam.controllers.impl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class RestActivator extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();

        classes.add(com.letsjam.controllers.interfaces.MusicianController.class);

        return classes;

    }
}