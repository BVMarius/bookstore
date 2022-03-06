package com.randomhouse.bookstore.repositories;

import com.randomhouse.bookstore.entities.UserEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);
}
