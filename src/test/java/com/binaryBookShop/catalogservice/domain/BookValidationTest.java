package com.binaryBookShop.catalogservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BookValidationTest {
    private static  Validator  validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
@Test
   void whenAllFieldsAreValidValidationSucceeds(){
        var book = new Book(
"1234567890","Java","Author",9.99
        );
       Set<ConstraintViolation<Book>> violations = validator.validate(book);
       assertThat(violations).isEmpty();
   }
@Test
    void whenAllFieldsAreNotValidValidationFails(){
        var book =
                new Book("a234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The ISBN format must be valid");
    }
}