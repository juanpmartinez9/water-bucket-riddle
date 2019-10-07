package com.waterbuckettest.math;

public class Mathematics {

    // Utility function to return GCD of 'a' and 'b'.
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
}
