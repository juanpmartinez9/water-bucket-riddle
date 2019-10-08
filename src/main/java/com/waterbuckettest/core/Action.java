package com.waterbuckettest.core;

public enum Action {
    INITIAL_STATE("Initial State"),
    FILL("Fill"),
    DUMP("Dump"),
    TRANSFER("Transfer");

    private String displayName;

    Action(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

}
