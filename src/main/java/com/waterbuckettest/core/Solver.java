package com.waterbuckettest.core;

import com.waterbuckettest.math.Mathematics;

public class Solver {

    /**
     * Solves actions and states of the riddle and returns an outcome.
     *
     * @param fromCap size of bucket from which water is poured
     * @param toCap f bucket to which water is poured
     * @param z the amount of water to be measured.
     * @return the solution of the riddle.
     */
    private Solution solve(int fromCap, int toCap, int z){
        // Initialize current amount of water
        // in source and destination bucket
        int from= 0;
        int to = 0;

        RiddleSolution solution = new WaterBucketRiddleSolution();

        // Buckets start empty
        solution.addStep("\nInitial State", from, to);

        // Add first step
        from = fromCap;
        solution.addStep("Fill         ",from, to);

        // Break the loop when either of the two
        // bucket has z gallon water
        while (from != z && to != z){
            // Find the maximum amount that can be poured
            int temp = Math.min(from, toCap - to);

            // Transfer "temp" litres from "from" to "to"
            to   += temp;
            from -= temp;

            // Add transfer step
            solution.addStep("Transfer     ",from, to);

            if (from == z || to == z)
                break;

            // If first bucket becomes empty, fill it
            if (from == 0) {
                from = fromCap;
                solution.addStep("Fill         ",from, to);
            }

            // If second bucket becomes full, dump it
            if (to == toCap) {
                to = 0;
                solution.addStep("Dump         ",from, to);
            }
        }
        return solution;
    }

    /**
     * Solves the Water Bucket Riddle and returns an outcome.
     *
     * @param x the size of the first bucket.
     * @param y the size of the second bucket.
     * @param z the amount of water to be measured.
     * @return the solution of the riddle.
     */
    public Solution solveRiddle(int x, int y, int z) {

        //If amount of water to be measured is bigger than the size of the two buckets
        // then solution is not possible
        if (z > Math.max(x, y)) {
            return new NoSolution("\nMeasure z is greater than max(BucketX, BucketY).\n");
        }

        // If gcd of x and y does not divide z
        // then solution is not possible
        if (Mathematics.isMultiple(x,y,z)){
            return new NoSolution("\nMeasure Z is not multiple of gcd(BucketX, BucketY).\n");
        }

        // Get the minimum number of steps with two cases:
        // a) Water of x gallon bucket is poured into y gallon bucket
        // b) Vice versa of "a"
        Solution solution1 = solve(y,x,z);
        Solution solution2 = solve(x,y,z);

        // Case with min number of steps returns solution
        if(Math.min(solution1.getSteps(),solution2.getSteps()) == solution1.getSteps()) {
            return solution1;
        }else {
            return solution2;
        }
    }
}
