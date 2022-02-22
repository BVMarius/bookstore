docker pull postgres:alpine
docker run -d --name postgres-first -e POSTGRES_PASSWORD=postgres -p 5433:5432 postgres:alpine
docker ps
docker exec -it postgres-first bash
\du
create  database qs_books;
\l
\c qs_books
\d



