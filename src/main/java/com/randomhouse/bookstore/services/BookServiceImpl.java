package com.randomhouse.bookstore.services;

import com.randomhouse.bookstore.entities.AuthorEntity;
import com.randomhouse.bookstore.entities.BookEntity;
import com.randomhouse.bookstore.exceptions.UnprocessableEntityException;
import com.randomhouse.bookstore.repositories.AuthorRepository;
import com.randomhouse.bookstore.repositories.BookRepository;
import com.randomhouse.bookstore.utils.Constants;
import com.randomhouse.bookstorecontrollers.model.Author;
import com.randomhouse.bookstorecontrollers.model.Book;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public void addBook(Book book) {

        Set<AuthorEntity> authorList = new HashSet<>();
        bookRepository.getBookEntitiesByBookTitle(book.getName()).ifPresent(b -> {
            throw new UnprocessableEntityException(
                    Constants.ENTITY_ALREADY_PRESENT, Constants.ENTITY_ALREADY_PRESENT_CODE,
                    b.getBookTitle());
        });
        if (book.getAuthors() != null) {
            for (Author author : book.getAuthors()) {
                authorRepository.getAuthorEntityByLastNameAndFirstName(author.getLastName(),
                        author.getFirstName()).ifPresentOrElse(authorList::add, () -> {
                    var authorEntity = new AuthorEntity();
                    authorEntity.setFirstName(author.getFirstName());
                    authorEntity.setLastName(author.getLastName());
                    authorEntity.setBooks(new HashSet<>());
                    authorList
                            .add(authorEntity);
                });

            }

            var bookEntity = new BookEntity();
            bookEntity.setAuthorEntityList(authorList);
            bookEntity.setBookTitle(book.getName());
            bookEntity.setIsbn(book.getIsbn());
            bookEntity.setPrice(book.getPrice());
            bookEntity.setGenre(book.getType().toString());
            var b = bookRepository.save(bookEntity);
            log.info("Book with id {} was created", b.getId());
        }
    }
}
