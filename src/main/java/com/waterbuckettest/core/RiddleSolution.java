package com.waterbuckettest.core;

import java.util.Collection;

public interface RiddleSolution {

    int getSteps();

    Collection<String> getActions();

    Collection<BucketState> getStates();

}
