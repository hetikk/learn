package com.github.hetikk.learn;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Testcontainers
public class PostgresContainerIsReadyTest {

    @Container
    private static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres"))
            .withReuse(true);

    @Test
    @SneakyThrows
    public void ping() {
        org.testcontainers.containers.Container.ExecResult pgIsReady = postgresContainer.execInContainer(
                "pg_isready",
                "--host=" + postgresContainer.getHost(),
                "--username=" + postgresContainer.getUsername(),
                "--dbname=" + postgresContainer.getDatabaseName()
        );
        int exitCode = pgIsReady.getExitCode();
        String stdout = pgIsReady.getStdout();
        boolean running = postgresContainer.isRunning();

        assertThat(exitCode, is(0));
        assertThat(stdout, is("localhost:5432 - accepting connections\n"));
        assertThat(running, is(true));
    }

}