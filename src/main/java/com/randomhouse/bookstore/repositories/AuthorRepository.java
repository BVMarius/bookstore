package com.randomhouse.bookstore.repositories;

import com.randomhouse.bookstore.entities.AuthorEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {

    Optional<AuthorEntity> getAuthorEntityByLastNameAndFirstName(String lastName, String firstName);

}
