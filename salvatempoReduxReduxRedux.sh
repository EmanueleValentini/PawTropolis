#!/bin/bash

echo "Seleziona l'ambiente da utilizzare: dev (sviluppo) o prod (produzione)"

read ambiente

if [ "$ambiente" == "dev" ]; then
    docker-compose -f docker-compose-dev.yml down
    docker-compose -f docker-compose-dev.yml up
    docker-compose -f docker-compose-dev.yml ps
elif [ "$ambiente" == "prod" ]; then
    docker-compose -f docker-compose-prod.yml down
    docker-compose -f docker-compose-prod.yml up
    docker-compose -f docker-compose-prod.yml ps
else
    echo "Ambiente inserito non valido"
fi








