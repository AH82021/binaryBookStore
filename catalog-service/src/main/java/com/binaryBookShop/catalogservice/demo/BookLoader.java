package com.binaryBookShop.catalogservice.demo;

import com.binaryBookShop.catalogservice.domain.Book;
import com.binaryBookShop.catalogservice.repository.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookLoader {
    private final BookRepository bookRepository;

    public BookLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
@EventListener(ApplicationReadyEvent.class)
    public void  loadBookTestData(){
        var b1 = new Book("1234567891", "Northern Lights", "Lyra Silverstar", 9.90);
        var b2 = new Book("1234567892", "Polar Journey", "Iorek Polarson", 12.90);
        bookRepository.save(b1);
        bookRepository.save(b2);

    }
}
