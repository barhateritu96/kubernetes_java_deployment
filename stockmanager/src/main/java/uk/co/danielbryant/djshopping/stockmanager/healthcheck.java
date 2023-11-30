package com.example.springbootmanagementexample;

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
            // Add your custom health check logic here
            // If everything is healthy, return Health.up()
            return Health.up().build();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // If there's an exception or a failure in your logic, return Health.down()
            return Health.down().withDetail("error", e.getMessage()).build();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthEndpoint() {
        try {
            // Add your custom health check logic here
            // If everything is healthy, return ResponseEntity.ok()
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // If there's an exception or a failure in your logic, return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
        }
    }
}
