package com.binaryBookShop.catalogservice.controller;

import com.binaryBookShop.catalogservice.domain.Book;
import com.binaryBookShop.catalogservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ap1/v1/books")
public class BookController {
  private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
    }
    @GetMapping("{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook( @RequestBody Book book) {
        return bookService.addBookToCatalog(book);
    }
    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String isbn){
        bookService.deleteBook(isbn);
    }

    @PutMapping("{isbn}")

    public Book updateBook(@PathVariable String isbn, @RequestBody Book book){
        return bookService.editBook(isbn,book);
    }

}
