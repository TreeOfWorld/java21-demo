package com.treeofworld.elf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ScopedApp
 *
 * @author: elf
 * @data: 2025/7/2
 * @version: 1.0
 */
@Slf4j
@SpringBootApplication
public class ScopedApp {

    public static void main(String[] args) {
        SpringApplication.run(ScopedApp.class, args);
        log.info("ScopedApp started");
    }

}
