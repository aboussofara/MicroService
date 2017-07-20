#!/bin/bash

set -e -u -x

cd source-code/
./mvnw package -DskipTests

pwd

cp target/*.jar ../package-output
