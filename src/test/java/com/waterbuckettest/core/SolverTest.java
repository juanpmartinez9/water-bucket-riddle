package com.waterbuckettest.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolverTest {

    @Test
    void testSolveRiddleActions() {
        Solution solution = new Solver().solveRiddle(5,4,3);
        final String[] input = new String[] { "\nInitial State", "Fill         ","Transfer     ","Fill         ","Transfer     " };
        Assertions.assertArrayEquals(((WaterBucketRiddleSolution)solution).getActions().toArray(), input);
    }

    @Test
    void testSolvedRiddleError() {
        Solution solution = new Solver().solveRiddle(5,4,3);
        final String[] input = new String[] { "\nInitial State", "Transfer     ","Fill         ","Transfer     " };
        Assertions.assertNotEquals(((WaterBucketRiddleSolution)solution).getActions().toArray(), input);
    }

    @Test
    void testMeasureBiggerThanXandY() {
        Solution solution = new Solver().solveRiddle(5,4,8);
        Assertions.assertEquals((solution).getSteps(), 0);
    }

    @Test
    void testNoSolutionGCD() {
        Solution solution = new Solver().solveRiddle(10,20,19);
        Assertions.assertEquals((solution).getSteps(), 0);
    }
}
