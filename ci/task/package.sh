#!/bin/bash

set -e -u -x
echo "checking code for packaging..."

cd source-code/
./mvnw package -DskipTests

pwd

ls -ll

cp target/*.jar package-output/.
