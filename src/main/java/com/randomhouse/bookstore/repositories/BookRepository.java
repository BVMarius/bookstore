package com.randomhouse.bookstore.repositories;


import com.randomhouse.bookstore.entities.BookEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    Optional<BookEntity> getBookEntitiesByBookTitle(String title);

}
