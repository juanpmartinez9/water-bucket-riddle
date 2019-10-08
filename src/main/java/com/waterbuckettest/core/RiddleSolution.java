package com.waterbuckettest.core;

import java.util.Collection;

public interface RiddleSolution{

    Collection<Action> getActions();

    Collection<BucketState> getStates();

    int getSteps();
}
