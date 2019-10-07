package com.waterbuckettest.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class MathematicsTest {

    @Test
    void testGCD() {
        assertSame(5, Mathematics.gcd(10, 5), "gcd between 10 and 5");
    }

    @Test
    void testGCDZero() {
        assertNotEquals(2, Mathematics.gcd(1, 5), "gcd between 2 and 5 cannot be 2");
    }
}
