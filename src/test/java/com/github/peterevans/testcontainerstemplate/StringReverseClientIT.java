package com.github.peterevans.testcontainerstemplate;

import org.junit.Test;

/**
 * Integration tests for StringReverseClient.
 */
public class StringReverseClientIT {
    @Test
    public void canReverseString() throws Exception {
        StringReverseClient srClient = new StringReverseClient("http://localhost:8080/");
    }
}
