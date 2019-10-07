package com.waterbuckettest.core;

import java.util.Collection;

public abstract class RiddleSolution implements Solution {

    //Actions for solving riddle
    Collection<String> actions;
    //States of each bucket during process
    Collection<BucketState> states;

    abstract Collection<String> getActions();

    abstract Collection<BucketState> getStates();

    @Override
    public abstract int getSteps();

}
