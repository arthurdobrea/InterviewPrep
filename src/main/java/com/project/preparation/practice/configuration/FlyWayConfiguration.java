package com.project.preparation.practice.configuration;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FlyWayConfiguration  implements FlywayMigrationStrategy {


    @Override
    public void migrate(Flyway flyway) {
        log.info("Inside migrate method");
        flyway.repair();
        flyway.migrate();
    }
}
