package com.randomhouse.bookstore.controllers.impl;

import com.randomhouse.bookstore.controllers.api.BookApi;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController implements BookApi {

public ResponseEntity<Void> getApiBookBookId(
        String authorization
        ,  String bookId
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default BookApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
