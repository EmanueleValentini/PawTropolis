@echo off

echo Seleziona l'ambiente da utilizzare: dev (sviluppo) o prod (produzione)

set /p ambiente=

if "%ambiente%"=="dev" (
    docker-compose -f docker-compose-dev.yml down
    docker-compose -f docker-compose-dev.yml up
    docker-compose -f docker-compose-dev.yml ps
) else if "%ambiente%"=="prod" (
    docker-compose -f docker-compose-prod.yml down
    docker-compose -f docker-compose-prod.yml up
    docker-compose -f docker-compose-prod.yml ps

) else (
    echo Ambiente inserito non valido
)
