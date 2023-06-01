#!/bin/bash

# Funzione per gestire l'errore
handle_error() {
  echo "Si e verificato un errore durante l'esecuzione del comando: $1"
  exit 1
}

# Spengi il container
echo "Sto spengendo il container"
docker stop postgres || handle_error "docker stop postgres"
echo "Ho spento il container"

# Cancella il container
echo "Sto rimuovendo il vecchio container"
docker rm postgres || handle_error "docker rm postgres"
echo "Ho rimosso il vecchio container"

# Avvio del container PostgreSQL
echo "Sto creando il nuovo container"
docker run --name postgres -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -e POSTGRES_DB=pawtropolis -p 5432:5432 -d library/postgres || handle_error "docker run postgres"
echo "Ho creato il nuovo container"
#Delay
echo "Attendi 2 secondi..."
sleep 2

# Copia dello script.sql nella cartella di lavoro corrente nel container PostgreSQL
echo "Sto copiando lo script sql nel container"
docker cp script.sql postgres:/script.sql || handle_error "docker cp script.sql"
echo "Ho copiato lo script sql nel container"

#Delay
echo "Attendi 5 secondi..."
sleep 5

# Esecuzione dello script.sql nel container PostgreSQL utilizzando winpty (se sei su Windows)
echo "Sto eseguendo lo script"
winpty docker exec -it postgres bash -c "psql -U root -d pawtropolis -f /script.sql" || handle_error "psql -f /script.sql"
echo "Ho eseguito lo script"
echo "Fatto, BELLAAAAAAA!"