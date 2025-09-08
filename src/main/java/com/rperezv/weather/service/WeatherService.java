package com.rperezv.weather.service;

import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * WeatherService
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 08/09/2025 - 16:53
 * @since 1.17
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

    private final ExternalServiceClient client;

    @Cacheable("weather")
    public int getInfo(int zipCode) {
        log.info("Getting weather info for zip code {}", zipCode);

        return 0;
    }

    @Scheduled(fixedRate = 10_000)
    public void update() {
        log.info("Updating weather info for zip codes 1 to 5");
        IntStream.rangeClosed(1, 5)
                .forEach(this.client::getWeatherInfo);
    }

}
