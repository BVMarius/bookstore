package com.randomhouse.bookstore.controllers.impl;

import com.randomhouse.bookstore.controllers.api.BookApi;
import com.randomhouse.bookstore.services.BookService;
import com.randomhouse.bookstorecontrollers.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BooksController implements BookApi {

    private final BookService bookService;


    @Override
    public ResponseEntity<Void> postBook(
            String authorization
            , Book body
    ) {
        log.info("Controller :-> Persist a book");
        bookService.addBook(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
