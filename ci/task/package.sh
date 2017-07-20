#!/bin/bash

set -e -u -x
echo "checking code for packaging..."

cd source-code/
./mvnw package

cp target/*.jar package-output/.
