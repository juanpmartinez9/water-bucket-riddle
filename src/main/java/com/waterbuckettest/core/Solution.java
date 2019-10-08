package com.waterbuckettest.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution implements RiddleSolution {

    private Collection<Action> actions;

    private Collection<BucketState> states;

    private Solution(Collection<Action> actions, Collection<BucketState> states){
        this.actions = actions;
        this.states = states;
    }

    Solution(){
        this(new ArrayList<Action>(), new ArrayList<BucketState>());
    }

    @Override
    public Collection<Action> getActions() {
        return Collections.unmodifiableCollection(actions);
    }

    @Override
    public Collection<BucketState> getStates() {
        return Collections.unmodifiableCollection(states);
    }

    @Override
    public int getSteps() {
        return states.size();
    }

    void addStep(Action action, int from, int to) {
        actions.add(action);
        BucketState bs = new BucketState();
        bs.setBucketX(to);
        bs.setBucketY(from);
        states.add(bs);
    }
}
