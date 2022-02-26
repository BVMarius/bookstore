package com.randomhouse.bookstore.repositories;

import com.randomhouse.bookstore.entities.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository  extends JpaRepository<UserEntity, UUID> {

}
