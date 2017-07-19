#!/bin/bash

set -e -u -x

cd source-code/
export http_proxy=http://fastweb.int.bell.ca:8083
export https_proxy=http://fastweb.int.bell.ca:8083
./mvnw package
