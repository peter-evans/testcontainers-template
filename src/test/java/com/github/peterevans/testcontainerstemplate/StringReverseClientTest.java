package com.github.peterevans.testcontainerstemplate;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for StringReverseClient.
 */
@Category(UnitTest.class)
public class StringReverseClientTest {
    @Test
    public void canCreateStringReverseClient() throws Exception {
        StringReverseClient srClient = new StringReverseClient("localhost", 8080);
        assertNotNull("An instance of StringReverseClient can be created.", srClient);
    }
}
