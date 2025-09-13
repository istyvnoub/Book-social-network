#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER postgres WITH SUPERUSER PASSWORD 'password';
    GRANT ALL PRIVILEGES ON DATABASE book_social_network TO postgres;
EOSQL
