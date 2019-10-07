package com.waterbuckettest.core;

public final class NoSolution implements Solution {

    private String errorMessage;

    NoSolution(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public int getSteps() {
        return 0;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
