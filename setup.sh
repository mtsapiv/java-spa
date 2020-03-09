#!/bin/bash

if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]
then
   echo "You should run: ./setup.sh SPA_PASSWORD SPA_USER SPA_ROOT_PASSWORD";
else
    export SPA_PASSWORD=$1
    export SPA_USER=$2
    export SPA_ROOT_PASSWORD=$3
    exec docker-compose up
fi
