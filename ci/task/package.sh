#!/bin/bash

set -e -u -x

cd source-code/
export MAVEN_OPTS=-Dhttp.proxyHost=fastweb.int.bell.ca -Dhttp.proxyPort=8083 -Dhttps.proxyHost=fastweb.int.bell.ca -Dhttps.proxyPort=8083
env
./mvnw package
