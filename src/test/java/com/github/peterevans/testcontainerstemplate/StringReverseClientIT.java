package com.github.peterevans.testcontainerstemplate;

import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;

/**
 * Integration tests for StringReverseClient.
 */
public class StringReverseClientIT {
    @Rule
    public GenericContainer srContainer = new GenericContainer(
            new ImageFromDockerfile()
                    .withFileFromClasspath("nginx.conf", "string-reverse-server/nginx.conf")
                    .withFileFromClasspath("Dockerfile", "string-reverse-server/Dockerfile"));

    @Test
    public void canReverseString() throws Exception {
        StringReverseClient srClient = new StringReverseClient("http://localhost:8080/");
    }
}
