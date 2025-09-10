package com.rperezv.city.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * City
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 10/09/2025 - 16:13
 * @since 1.17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {

    private String zip;
    private String city;
    private String stateName;
    private int temperature;

}
