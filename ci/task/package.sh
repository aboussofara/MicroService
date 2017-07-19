#!/bin/bash

set -e -u -x

cd source-code/
set MAVEN_OPTS=-Dhttp.proxyHost=142.117.128.44 -Dhttp.proxyPort=8083 -Dhttps.proxyHost=142.117.128.44 -Dhttps.proxyPort=8083
./mvnw package
