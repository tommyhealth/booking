package ru.fallindawn.booking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.ext.ScriptUtils;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.lifecycle.Startables;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(initializers = {AbstractIntegrationTest.Initializer.class})
@Testcontainers
public class AbstractIntegrationTest {

    @Container
    public static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("integration-tests-db")
            .withUsername("sa")
            .withPassword("sa");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @DynamicPropertySource
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            Startables.deepStart(postgres).join();
            var containerDelegate = new JdbcDatabaseDelegate(postgres, "");
            ScriptUtils.runInitScript(containerDelegate, "sql/tables_init.sql");
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgres.getJdbcUrl(),
                    "spring.datasource.username=" + postgres.getUsername(),
                    "spring.datasource.password=" + postgres.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    void test() {
        assertTrue(postgres.isRunning());
    }
}
