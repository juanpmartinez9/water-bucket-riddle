package com.waterbuckettest.core;

import java.util.Collection;
import java.util.Collections;

public final class NoSolution implements RiddleSolution {

    private String errorMessage;

    NoSolution(String errorMessage) {
        this.errorMessage = "\nNo solution. " + errorMessage;
    }

    @Override
    public Collection<Action> getActions() {
        return Collections.emptyList();
    }

    @Override
    public Collection<BucketState> getStates() {
        return Collections.emptyList();
    }

    @Override
    public int getSteps() {
        return 0;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
