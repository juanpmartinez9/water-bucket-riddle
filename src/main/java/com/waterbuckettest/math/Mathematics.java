package com.waterbuckettest.math;

public class Mathematics {

    // Utility function to return GCD of 'a' and 'b'.
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }

    public static boolean isMultiple(int x, int y, int z){
        return (z % Mathematics.gcd(y, x)) != 0;
    }
}
