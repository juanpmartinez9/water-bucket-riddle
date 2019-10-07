package com.waterbuckettest.core;

import java.util.ArrayList;
import java.util.Collection;

public class Solution implements RiddleSolution {


    //Actions for solving riddle
    private Collection<String> actions;
    //States of each bucket during process
    private Collection<BucketState> states;

    Solution(){
        actions = new ArrayList<>();
        states = new ArrayList<>();
    }

    public Collection<String> getActions() {
        return actions;
    }

    public Collection<BucketState> getStates() {
        return states;
    }

    @Override
    public int getSteps() {
        return states.size();
    }
}
