#!/bin/bash

# Spengi il container
docker stop postgres

# Cancella il container
docker rm postgres

# Avvio del container PostgreSQL
docker run --name postgres -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -e POSTGRES_DB=pawtropolis -p 5432:5432 -d library/postgres

# Copia dello script.sql nella cartella di lavoro corrente nel container PostgreSQL
docker cp script.sql postgres:/script.sql

# Esecuzione dello script.sql nel container PostgreSQL utilizzando winpty (se sei su winzoz)
winpty docker exec -it postgres bash -c "psql -U root -d pawtropolis -f /script.sql"