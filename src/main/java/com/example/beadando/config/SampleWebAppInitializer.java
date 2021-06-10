package com.example.beadando.config;


import com.vaadin.flow.spring.VaadinMVCWebAppInitializer;

import java.util.Collection;
import java.util.Collections;

public class SampleWebAppInitializer extends VaadinMVCWebAppInitializer {
    @Override
    protected Collection<Class<?>> getConfigurationClasses() {
        return Collections.singletonList(
                SampleConfiguration.class);
    }
}
