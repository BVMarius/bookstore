package com.randomhouse.bookstore.controllers.impl;

import com.randomhouse.bookstore.controllers.api.AuthorApi;
import com.randomhouse.bookstore.entities.AuthorEntity;
import com.randomhouse.bookstore.services.AuthorService;
import com.randomhouse.bookstorecontrollers.model.Author;

import io.swagger.annotations.ApiParam;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorsController implements AuthorApi {


    private final AuthorService authorService;

    @Override
    public ResponseEntity<Void> postAuthor(
            @ApiParam(value = "", required = true) @RequestHeader(value = "Authorization", required = true) String authorization
            , @ApiParam(value = "") @Valid @RequestBody Author body
    ) {
        var authorEntity = new AuthorEntity();
        authorEntity.setFirstName(body.getFirstName());
        authorEntity.setLastName(body.getLastName());
        authorService.createAuthor(authorEntity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
