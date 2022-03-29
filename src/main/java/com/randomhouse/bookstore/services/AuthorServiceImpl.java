package com.randomhouse.bookstore.services;

import com.randomhouse.bookstore.entities.AuthorEntity;
import com.randomhouse.bookstore.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Override
    public void createAuthor(AuthorEntity authorEntity) {

        authorRepository.save(authorEntity);

    }
}
