#!/bin/bash

set -e -u -x

cd source-code/
./mvnw package -DskipTests

cp target/*.jar ../package-output

pwd
ls
