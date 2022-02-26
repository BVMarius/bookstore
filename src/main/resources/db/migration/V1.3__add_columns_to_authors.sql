ALTER TABLE "public"."authors"
ADD COLUMN inserted_at timestamp not null,
ADD COLUMN updated_at timestamp not null;
