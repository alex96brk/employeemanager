package tech.getarrays.employeemanager.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class LoggerService implements HealthIndicator {

    private final String LOGGER_SERVICE = "Logger Service";
    private final String LOGGER_SERVICE_UP_MESSAGE = "Logger Service is available";
    private final String LOGGER_SERVICE_DOWN_MESSAGE = "Logger Service is not available";

    @Override
    public Health health() {
        Health loggerServiceHealth = Health.down().withDetail(LOGGER_SERVICE, LOGGER_SERVICE_DOWN_MESSAGE).build();
        if(isLoggerServiceGood()) {
            loggerServiceHealth = Health.up().withDetail(LOGGER_SERVICE, LOGGER_SERVICE_UP_MESSAGE).build();
        }
        return loggerServiceHealth;
    }

    private boolean isLoggerServiceGood() {
        return false;
    }

}
