package com.waterbuckettest.core;

public class BucketState {

    private int bucketX;
    private int bucketY;

    BucketState(){}

    public int getBucketX() {return bucketX;}

    void setBucketX(int bucketX) {
        this.bucketX = bucketX;
    }

    public int getBucketY() {
        return bucketY;
    }

    void setBucketY(int bucketY) {
        this.bucketY = bucketY;
    }
}
