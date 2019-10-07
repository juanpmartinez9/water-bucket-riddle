package com.waterbuckettest.core;

import java.util.ArrayList;
import java.util.Collection;

public class WaterBucketRiddleSolution extends RiddleSolution {

    WaterBucketRiddleSolution(){
        actions = new ArrayList<String>();
        states = new ArrayList<BucketState>();
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

    @Override
    void addStep(String action, int from, int to) {
        getActions().add(action);
        BucketState bs = new BucketState();
        bs.setBucketX(to);
        bs.setBucketY(from);
        getStates().add(bs);
    }
}
