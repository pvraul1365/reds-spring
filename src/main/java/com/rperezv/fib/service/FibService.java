package com.rperezv.fib.service;

import lombok.extern.slf4j.Slf4j;
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

    public int getFib(int index) {

        log.info("Calculating fib({})", index);

        return fib(index);
    }

    // Naive recursive implementation of Fibonacci
    private int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
