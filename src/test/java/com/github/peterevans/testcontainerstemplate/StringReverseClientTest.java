package com.github.peterevans.testcontainerstemplate;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit tests for StringReverseClient.
 */
@Category(UnitTest.class)
public class StringReverseClientTest {
    @Test
    public void canCreateStringReverseClient() throws Exception {
        StringReverseClient srClient = new StringReverseClient("localhost", 8080);
    }
}
