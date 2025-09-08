package com.rperezv.weather.service;

import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * ExternalServiceClient
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 08/09/2025 - 16:56
 * @since 1.17
 */
@Service
@Slf4j
public class ExternalServiceClient {

    @CachePut(value = "weather", key = "#zipCode")
    public int getWeatherInfo(int zipCode) {
        log.info("Calling external service for zip code {}", zipCode);

        // Simulate an external service call with a dummy implementation
        return ThreadLocalRandom.current().nextInt(60, 100);
    }

}
