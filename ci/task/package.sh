#!/bin/bash

set -e -u -x

cd source-code/
./mvnw package -DskipTests

pwd

cd ci
ls
cd task
ls

cp target/*.jar package-output/.
