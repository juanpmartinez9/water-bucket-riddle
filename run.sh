#!/bin/sh

docker build -f Dockerfile -t water-bucket-riddle .
docker run -i -t water-bucket-riddle
