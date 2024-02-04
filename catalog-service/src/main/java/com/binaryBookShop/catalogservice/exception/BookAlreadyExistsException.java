package com.binaryBookShop.catalogservice.exception;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {

        super("book with ISBN "+isbn+ " already exists");
    }
}
