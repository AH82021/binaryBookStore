package com.binaryBookShop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(
@NotBlank(message = "The book must have isbn ")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$" ,
                message ="The ISBN format must be valid"
        )
        String isbn,

        @NotBlank(
                message = "The book cannot be empty "
        )
        
        String title,
        @NotBlank(message = "The book must have an author")
        String author,
        @NotNull(message = "The book price must be defined.")
                @Positive(message = "The book price must be greater than zero")
        Double price
) { }
