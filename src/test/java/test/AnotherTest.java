package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnotherTest {

    @Test
    public void testAFailure() {
        // Causes failure since 100 != 101
    	assertEquals("100", "101");
        
    }
}