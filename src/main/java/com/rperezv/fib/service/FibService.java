package com.rperezv.fib.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * FibService
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 07/09/2025 - 17:42
 * @since 1.17
 */
@Service
@Slf4j
public class FibService {

    // hava a strategy for cache evict
    @Cacheable(value = "math:fib", key = "#index")
    public int getFib(int index) {
        log.info("Calculating fib({})", index);

        return fib(index);
    }

    // PUT / POST / PATCH / DELETE
    @CacheEvict(value = "math:fib", key = "#index")
    public void clearCache(int index) {
        log.info("Clearing hash key cache");
    }

    @Scheduled(fixedRate = 10_000) // every 5 minutes
    @CacheEvict(value = "math:fib", allEntries = true)
    public void clearCache() {
        log.info("Clearing all fib keys");
    }

    // Naive recursive implementation of Fibonacci
    private int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
