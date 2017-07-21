#!/bin/bash

set -e -u -x

cd source-code/
./mvnw package -DskipTests

cp target/*.jar ../package-output
cp Dockerfile  ../package-output
