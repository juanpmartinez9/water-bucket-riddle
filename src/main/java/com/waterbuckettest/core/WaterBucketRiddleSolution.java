package com.waterbuckettest.core;

import java.util.ArrayList;
import java.util.Collection;

public class WaterBucketRiddleSolution extends RiddleSolution {

    WaterBucketRiddleSolution(){
        actions = new ArrayList<>();
        states = new ArrayList<>();
    }

    @Override
    public Collection<String> getActions() {
        return actions;
    }

    @Override
    public Collection<BucketState> getStates() {
        return states;
    }

    @Override
    public int getSteps() {
        return states.size();
    }
}
