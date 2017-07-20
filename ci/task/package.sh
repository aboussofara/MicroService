#!/bin/bash

set -e -u -x

cd source-code/
./mvnw package -DskipTests

pwd
cd ~/package-output
cd source-code/
cp target/*.jar ../package-output
