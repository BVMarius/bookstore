package com.randomhouse.bookstore.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class TimeStampEntityId extends EntityIdGenerator {

    @Column(name="inserted_at")
    private Timestamp insertedAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    public void changeData(){
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
        insertedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    public  void updateData(){
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

}
