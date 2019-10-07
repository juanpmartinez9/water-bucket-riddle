package com.waterbuckettest.core;

import java.util.Collection;

public final class NoSolution implements RiddleSolution {

    @Override
    public int getSteps() {
        return 0;
    }

    @Override
    public Collection<String> getActions() {
        return null;
    }

    @Override
    public Collection<BucketState> getStates() {
        return null;
    }
}
