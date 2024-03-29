package com.binaryBookShop.catalogservice.controller;

import com.binaryBookShop.catalogservice.exception.BookNotFoundException;
import com.binaryBookShop.catalogservice.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;
@Test

    void whenGetBookNotExistingThenShouldReturn404() throws Exception {
        String isbn = "12233444444";
        given(bookService.getBookByIsbn(isbn))
                .willThrow(BookNotFoundException.class);
        mockMvc.perform(get("/api/v1/books"+isbn))
                .andExpect(status().isNotFound());

    }

}