#!/bin/bash

set -e -u -x
echo "checking code for packaging..."

cd source-code/
./mvnw package -DskipTests

cp target/*.jar package-output/.
