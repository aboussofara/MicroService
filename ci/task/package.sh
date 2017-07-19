#!/bin/bash

set -e -u -x

cd source-code/
./mvnw package -DproxySet=true -DproxyHost=fastweb.int.bell.ca -DproxyPort=8083
