package com.mysite.core.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.core.config.WeatherConfiguration;
import com.mysite.core.dto.WeatherResponse;
import com.mysite.core.service.WeatherService;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(service = WeatherService.class)
@Designate(ocd = WeatherConfiguration.class)
public class WeatherServiceImpl implements WeatherService {


    private static final Logger LOG =
            LoggerFactory.getLogger(WeatherServiceImpl.class);

    private String apiKey;
    private String apiUrl;

    @Activate
    protected void activate(
            WeatherConfiguration configuration) {

        this.apiKey = configuration.apiKey();
        this.apiUrl = configuration.apiUrl();
    }

    @Override
    public WeatherResponse getWeather(
            String location) {

        WeatherResponse weather =
                new WeatherResponse();

        try {

            String url =
                    apiUrl
                            + "?q="
                            + location
                            + "&units=metric"
                            + "&appid="
                            + apiKey;
            LOG.info("Calling URL: {}", url);

            HttpClient client =
                    HttpClient.newHttpClient();

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .GET()
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString());
            LOG.info("Calling response: {}", response);
            ObjectMapper mapper =
                    new ObjectMapper();

            JsonNode root =
                    mapper.readTree(response.body());

            weather.setLocation(location);

            weather.setTemperature(
                    root.path("main")
                            .path("temp")
                            .asDouble());

            weather.setHumidity(
                    root.path("main")
                            .path("humidity")
                            .asInt());

            weather.setDescription(
                    root.path("weather")
                            .get(0)
                            .path("description")
                            .asText());

            String icon =
                    root.path("weather")
                            .get(0)
                            .path("icon")
                            .asText();

            weather.setIconUrl(
                    "https://openweathermap.org/img/wn/"
                            + icon
                            + "@2x.png");

            weather.setCountry(
                     root.path("sys")
                    .path("country")
                             .asText());

            LOG.info("Location received: {}", location);
            LOG.info("API URL: {}", apiUrl);
            LOG.info("API Key Present: {}", apiKey != null);

        } catch (IOException e) {

            e.printStackTrace();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        return weather;
    }

}