package com.waterbuckettest.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathematicsTest {

    @Test
    void testGCD() {
        assertSame(5, Mathematics.gcd(10, 5), "5 is gcd between 10 and 5");
        assertNotEquals(3, Mathematics.gcd(1, 2), "3 is not gcd between 1 and 2");
    }

    @Test
    void testIsMultiple() {
        assertTrue(Mathematics.isMultiple(0, 5,1), "0 is not multiple of 1 and 5");
        assertFalse(Mathematics.isMultiple(7, 5,4), "7 is not multiple of 5 and 4");
    }
}
