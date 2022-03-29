

CREATE TABLE if not exists "public"."users"
(
   id uuid PRIMARY KEY NOT NULL,
   first_name varchar(255),
   last_name varchar(255),
   email varchar(255),
   inserted_at timestamp NOT NULL,
   updated_at timestamp NOT NULL,
   password varchar(255),
   user_type varchar(255) DEFAULT 'user'::character varying NOT NULL
);
CREATE UNIQUE INDEX if not exists users_email_index ON "public"."users"(email);

CREATE TABLE if not exists "public"."books"
(
   id uuid PRIMARY KEY NOT NULL,
   name varchar(255) NOT NULL,
   type varchar(255),
   price int4,
   isbn varchar(255) NOT NULL,
   inserted_at timestamp NOT NULL,
   updated_at timestamp NOT NULL
);
CREATE UNIQUE INDEX if not exists books_id_index ON "public"."books"(id);

CREATE TABLE if not exists "public"."authors"
(
  id uuid PRIMARY KEY NOT NULL,
   first_name varchar(255),
   last_name varchar(255)
);
CREATE UNIQUE INDEX if not exists authors_id_index ON "public".authors(id);


