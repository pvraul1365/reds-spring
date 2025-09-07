package com.rperezv.fib.controller;

import com.rperezv.fib.service.FibService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * FibController
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 07/09/2025 - 17:46
 * @since 1.17
 */
@RestController
@RequestMapping("fib")
@RequiredArgsConstructor
public class FibController {

    private final FibService service;

    @GetMapping("{index}")
    public Mono<Integer> getFib(@PathVariable int index) {
        return Mono.fromSupplier(() -> service.getFib(index));
    }

}
