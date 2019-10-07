package com.waterbuckettest.core;

import com.waterbuckettest.math.Mathematics;

public class Solver {

    /**
     * Solves the Water Jug Riddle and returns an outcome.
     *
     * @param fromCap size of bucket from which water is poured
     * @param toCap f bucket to which water is poured
     * @param z the amount of water to be measured.
     * @return the solution of the riddle.
     */
    private RiddleSolution solve(int fromCap, int toCap, int z){
        // Initialize current amount of water
        // in source and destination bucket
        int from= 0;
        int to = 0;
        BucketState bs;
        RiddleSolution rs = new Solution();


        // Buckets start empty
        bs = new BucketState();
        rs.getActions().add("\nInitial State");
        bs.setBucketX(to);
        bs.setBucketY(from);
        rs.getStates().add(bs);

        from = fromCap;
        // Add action
        rs.getActions().add("Refill       ");
        // Add state
        bs = new BucketState();
        bs.setBucketX(to);
        bs.setBucketY(from);
        rs.getStates().add(bs);

        // Break the loop when either of the two
        // bucket has d litre water
        while (from != z && to != z){
            // Find the maximum amount that can be
            // poured
            int temp = Math.min(from, toCap - to);

            // Pour "temp" litres from "from" to "to"
            to   += temp;
            from -= temp;


            // Add action
            rs.getActions().add("Transfer     ");
            // Add state
            bs = new BucketState();
            bs.setBucketX(to);
            bs.setBucketY(from);
            rs.getStates().add(bs);



            if (from == z || to == z)
                break;

            // If first bucket becomes empty, fill it
            if (from == 0) {
                from = fromCap;

                // Add action
                rs.getActions().add("Refill       ");
                // Add state
                bs = new BucketState();
                bs.setBucketX(to);
                bs.setBucketY(from);
                rs.getStates().add(bs);
            }

            // If second bucket becomes full, empty it
            if (to == toCap) {
                to = 0;

                // Add action
                rs.getActions().add("Empty        ");
                // Add state
                bs = new BucketState();
                bs.setBucketX(to);
                bs.setBucketY(from);
                rs.getStates().add(bs);

            }
        }
        return rs;
    }

    /**
     * Solves the Water Jug Riddle and returns an outcome.
     *
     * @param x the size of the first bucket.
     * @param y the size of the second bucket.
     * @param z the amount of water to be measured.
     * @return the solution of the riddle.
     */
    public RiddleSolution solveRiddle(int x, int y, int z) {


        if (z > Math.max(x, y)) {
            System.out.println("Measure z is greater than max(BucketX, BucketY).\n");
            return new NoSolution();
        }


        // If gcd of x and y does not divide z
        // then solution is not possible
        if ((z % Mathematics.gcd(y, x)) != 0){
            System.out.println("Measure Z is not multiple of gcd(BucketX, BucketY).\n");
            return new NoSolution();
        }


        // Get the minimum number of steps with two cases:
        // a) Water of x gallon bucket is poured into y gallon bucket
        // b) Vice versa of "a"
        RiddleSolution solution1 = solve(y,x,z);
        RiddleSolution solution2 = solve(x,y,z);

        // Case with min number of steps returns solution
        if(Math.min(solution1.getSteps(),solution2.getSteps()) == solution1.getSteps()) {
            return solution1;
        }else {
            return solution2;
        }
    }
}
