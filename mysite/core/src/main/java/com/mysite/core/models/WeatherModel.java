package com.mysite.core.models;

import javax.annotation.PostConstruct;

import com.mysite.core.dto.WeatherResponse;
import com.mysite.core.service.WeatherService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy =
                DefaultInjectionStrategy.OPTIONAL)
public class WeatherModel {
    private static final Logger LOG =
            LoggerFactory.getLogger(WeatherModel.class);

    @ValueMapValue
    private String location;

    @OSGiService
    private WeatherService weatherService;

    private WeatherResponse weather;

    @PostConstruct
    protected void init() {

        LOG.info("Location = {}", location);
        LOG.info("Weather Service = {}", weatherService);

        if (weatherService != null
                && location != null
                && !location.isEmpty()) {

            weather = weatherService.getWeather(location);

            LOG.info("Weather Response = {}", weather);
        }
    }

    public WeatherResponse getWeather() {
        return weather;
    }

    public String getLocation() {
        return location;
    }
}