#!/bin/bash

# Funzione per gestire l'errore
handle_error() {
  echo "Si e verificato un errore durante l'esecuzione del comando: $1"
  exit 1
}

# Spengi il container
docker stop postgres || handle_error "docker stop postgres"

# Cancella il container
docker rm postgres || handle_error "docker rm postgres"

# Avvio del container PostgreSQL
docker run --name postgres -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -e POSTGRES_DB=pawtropolis -p 5432:5432 -d library/postgres || handle_error "docker run postgres"

# Copia dello script.sql nella cartella di lavoro corrente nel container PostgreSQL
docker cp script.sql postgres:/script.sql || handle_error "docker cp script.sql"

# Esecuzione dello script.sql nel container PostgreSQL utilizzando winpty (se sei su Windows)
winpty docker exec -it postgres bash -c "psql -U root -d pawtropolis -f /script.sql" || handle_error "psql -f /script.sql"