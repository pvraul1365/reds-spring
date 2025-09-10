package com.rperezv.city.service;

import com.rperezv.city.client.CityClient;
import com.rperezv.city.dto.City;
import org.redisson.api.RMapReactive;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * CityService
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 10/09/2025 - 18:35
 * @since 1.17
 */
@Service
public class CityService {

    @Autowired
    private CityClient cityClient;

    private RMapReactive<String, City> cityMap;

    public CityService(RedissonReactiveClient client) {
        this.cityMap = client.getMap("city", new TypedJsonJacksonCodec(String.class, City.class));
    }

    // get from cache
    // if empty - get from db / source
    // put it in cache
    // return
    public Mono<City> getCity(final String zipCode) {
        return this.cityMap.get(zipCode)
                .switchIfEmpty(
                        this.cityClient.getCity(zipCode)
                                .flatMap(city -> this.cityMap.fastPut(zipCode, city)
                                        .thenReturn(city))
                );
    }

}
