package com.github.peterevans.testcontainerstemplate;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.Wait;
import org.testcontainers.images.builder.ImageFromDockerfile;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests for StringReverseClient.
 */
@Category(IntegrationTest.class)
public class StringReverseClientIT {

    private StringReverseClient srClient;

    @ClassRule
    public static final GenericContainer srContainer = new GenericContainer(
            new ImageFromDockerfile()
                    .withFileFromClasspath("nginx.conf", "string-reverse-server/nginx.conf")
                    .withFileFromClasspath("Dockerfile", "string-reverse-server/Dockerfile"))
                    .withExposedPorts(8080)
                    .waitingFor(Wait.forHttp("/"));

    @Before
    public void setUp() throws Exception {
        srClient = new StringReverseClient(
                srContainer.getContainerIpAddress(),
                srContainer.getMappedPort(8080));
    }

    @Test
    public void canReverseString() throws Exception {
        String expected = "em-esrever";
        String actual = srClient.reverse("reverse-me");
        assertEquals("A string can be reversed using the 'reverse' API endpoint.", expected, actual);
    }
}
