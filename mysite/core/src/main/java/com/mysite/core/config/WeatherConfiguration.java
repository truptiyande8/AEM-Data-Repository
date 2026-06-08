package com.mysite.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
        name = "Weather API Configuration")
public @interface WeatherConfiguration {

    @AttributeDefinition(
            name = "API Key")
    String apiKey();

    @AttributeDefinition(
            name = "Weather API URL")
    String apiUrl();
}