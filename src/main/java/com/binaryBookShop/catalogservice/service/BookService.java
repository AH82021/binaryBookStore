package com.binaryBookShop.catalogservice.service;

import com.binaryBookShop.catalogservice.domain.Book;
import com.binaryBookShop.catalogservice.exception.BookAlreadyExistsException;
import com.binaryBookShop.catalogservice.exception.BookNotFoundException;
import com.binaryBookShop.catalogservice.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(()-> new BookNotFoundException("isbn"));
    }

    public Book addBookToCatalog(Book book) {
        if(bookRepository.existsByIsbn(book.isbn())){
            throw  new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBook(String isbn,Book book){
        return bookRepository.findByIsbn(isbn)
                .map(existingBook ->{
                    var bookToUpdate = new Book(
                            book.isbn(),
                            book.title(),
                            book.author(),
                            book.price());
                    return bookRepository.save(bookToUpdate);

                })
                .orElseGet(()-> addBookToCatalog(book));
    }

}
