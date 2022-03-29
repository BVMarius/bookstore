docker pull postgres:alpine
docker run -d --name postgres-first -e POSTGRES_PASSWORD=postgres -p 5433:5432 postgres:alpine
docker ps
docker exec -it postgres-first bash
#log in into postgres client from docker 
psql -U postgres
create  database qs_books;
\l
\c qs_books
\d


POST  http://localhost:8081/api/book

{
  "name": "The Alchemist",
  "type": "FICTION",
  "price": 3,
  "isbn": "978-0061233845",
  "authors": [
    {
      "firstName": "Paulo",
      "lastName": "Coelho"
    }
  ]
}


{
  "name": "Modern Art: A Critical Introduction ",
  "type": "OTHERS",
  "price": 26,
  "isbn": "978-0415281942",
  "authors": [
    {
      "firstName": "Julie",
      "lastName": "Sheldon"
    },
    {
      "firstName": "Pam",
      "lastName": "Meecham"
    }
  ]
}

{
  "name": "One Step at a Time: A Story of Endurance and Perseverance",
  "type": "OTHERS",
  "price": 9,
  "isbn": "978-0340746233",
  "authors": [
    {
      "firstName": "Julie",
      "lastName": "Sheldon"
    },
    {
      "firstName": "Lucy",
      "lastName": "Elphinstone"
    }
  ]
}



