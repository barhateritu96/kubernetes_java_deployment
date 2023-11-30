/*package com.example.springbootmanagementexample;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SimpleRestController implements HealthIndicator {

    @GetMapping("/example")
    public String example() {
        return "Hello User !! " + new Date();
    }

    @Override
    public Health health() {
        try {
            return Health.up().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Health.down().withDetail("error", e.getMessage()).build();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthEndpoint() {
        try {
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
        }
    }
}*/

package uk.co.danielbryant.djshopping.stcokmanager.healthchecks;

import com.codahale.metrics.health.HealthCheck;

public class BasicHealthCheck extends HealthCheck {

    private final String version;

    public BasicHealthCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy("Ok with version: " + version);
    }
}
