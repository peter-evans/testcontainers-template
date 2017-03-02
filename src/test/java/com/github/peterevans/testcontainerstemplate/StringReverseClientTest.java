package com.github.peterevans.testcontainerstemplate;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for StringReverseClient.
 */
@Category(UnitTest.class)
public class StringReverseClientTest {
    @Rule
    public MockWebServer mockWebServer = new MockWebServer();

    @Test
    public void canCreateStringReverseClient() throws Exception {
        StringReverseClient srClient = new StringReverseClient("localhost", 8080);
        assertNotNull("An instance of StringReverseClient can be created.", srClient);
    }

    @Test
    public void canReverseString() throws Exception {
        String testStr = "reverse-me";
        String expected = "em-esrever";

        StringReverseClient srClient = new StringReverseClient(mockWebServer.getHostName(), mockWebServer.getPort());
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(expected));

        assertEquals("A string can be reversed by calling the reverse method",
                srClient.reverse(testStr),
                expected);
    }
}
