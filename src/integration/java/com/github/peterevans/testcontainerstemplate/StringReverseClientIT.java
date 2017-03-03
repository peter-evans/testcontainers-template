package com.github.peterevans.testcontainerstemplate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests for StringReverseClient.
 */
@Category(IntegrationTest.class)
public class StringReverseClientIT {
    @Rule
    public GenericContainer srContainer = new GenericContainer(
            new ImageFromDockerfile()
                    .withFileFromClasspath("nginx.conf", "string-reverse-server/nginx.conf")
                    .withFileFromClasspath("Dockerfile", "string-reverse-server/Dockerfile"))
                    .withExposedPorts(8080);

    private StringReverseClient srClient;

    @Before
    public void setUp() throws Exception {
        srClient = new StringReverseClient(
                srContainer.getContainerIpAddress(),
                srContainer.getMappedPort(8080));
    }

    @Test
    public void canReverseString() throws Exception {
        String testStr = "reverse-me";
        String expected = "em-esrever";
        String actual = srClient.reverse(testStr);
        assertEquals("A string can be reversed using the 'reverse' API endpoint.", expected, actual);
    }
}
