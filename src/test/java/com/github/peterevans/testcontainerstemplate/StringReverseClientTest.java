package com.github.peterevans.testcontainerstemplate;

import org.junit.Test;

/**
 * Tests for StringReverseClient.
 */
public class StringReverseClientTest {
    @Test
    public void canCreateStringReverseClient() throws Exception {
        StringReverseClient srClient = new StringReverseClient("http://localhost:8080/");
    }
}
