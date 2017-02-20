package com.github.peterevans.testcontainerstemplate;

import org.junit.Test;

/**
 * Unit tests for StringReverseClient.
 */
public class StringReverseClientTest {
    @Test
    public void canCreateStringReverseClient() throws Exception {
        StringReverseClient srClient = new StringReverseClient("http://localhost:8080/");
    }
}
