# Water Bucket Riddle

Build an application that solves the Water Bucket Riddle for dynamic inputs (Bucket_X, Bucket_Y, Amount_Z)


## Overview

There are 2 buckets. Irregular shape, can’t guess at partial capacity.

Large Bucket = 5 Gallons

Small Bucket = 3 Gallons

Target is 4 gallons into 5 gallon bucket

There is a lake with unlimited water supply to fill the bucket.

## Limitations

a)       Fill empty bucket from lake in full. 5 gallon empty bucket can be filled with 5 gallons from lake. Can’t fill 2 gallons into 5 gallon bucket from lake.

b)      All water must be dump, cannot pour out “just a bit” or “half”.

c)      Can transfer from one bucket to another until capacity.

## Goals

App should find a way to get to 4 gallons in large bucket.

The program should accept size value for large bucket, small bucket, and target size.

If values are invalid, such as letters or negative numbers or 0s, it should not crash.

If values cannot be solved, such as large size of 8 small size of 2 and target 3, the app should state that.

The output on the screen has to demonstrates each step (fill, dump, transfer, etc.) until the target is achieved.

## How to run the application

Use docker [docker](https://www.docker.com/) to run waterBucketApp.

```bash
docker java -jar waterBucketApp.jar
```
