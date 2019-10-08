package com.waterbuckettest.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolverTest {

    @Test
    void testSolveRiddleActions() {
        RiddleSolution solution = new Solver().solveRiddle(5,4,3);
        final Action[] input = new Action[] { Action.INITIAL_STATE, Action.FILL, Action.TRANSFER, Action.FILL, Action.TRANSFER};
        Assertions.assertArrayEquals(solution.getActions().toArray(), input);
    }

    @Test
    void testSolvedRiddleError() {
        RiddleSolution solution = new Solver().solveRiddle(5,4,3);
        final Action[] input = new Action[] { Action.INITIAL_STATE, Action.TRANSFER, Action.FILL, Action.TRANSFER};
        Assertions.assertNotEquals(solution.getActions().toArray(), input);
    }

    @Test
    void testMeasureBiggerThanXandY() {
        RiddleSolution solution = new Solver().solveRiddle(5,4,8);
        Assertions.assertEquals(solution.getSteps(), 0);
    }

    @Test
    void testNoSolutionGCD() {
        RiddleSolution solution = new Solver().solveRiddle(10,20,19);
        Assertions.assertEquals(solution.getSteps(), 0);
    }
}
