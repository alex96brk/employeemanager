package tech.getarrays.employeemanager.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService implements HealthIndicator {

    private final String DATABASE_SERVICE = "Database Service";
    private final String DATABASE_HEALTH_UP_MESSAGE = "Service is available";
    private final String DATABASE_HEALTH_DOWN_MESSAGE = "Service is not available";

    @Override
    public Health health() {
        Health databaseHealth = Health.down().withDetail(DATABASE_SERVICE, DATABASE_HEALTH_DOWN_MESSAGE).build();
        if(isDatabaseHealthGood()) {
            databaseHealth = Health.up().withDetail(DATABASE_SERVICE, DATABASE_HEALTH_UP_MESSAGE).build();
        }
        return databaseHealth;
    }

    private boolean isDatabaseHealthGood() {
        return true;
    }
}
