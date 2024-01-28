package com.binaryBookShop.catalogservice;

import com.binaryBookShop.catalogservice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
		//Loads a full Spring web application context and a Servlet container listening on a random port
		webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT
)
class CatalogServiceApplicationTests {
	//Utility to perform REST calls for testing
	@Autowired
	private WebTestClient webClient;
	// To Do

	@Test
	void whenPostRequestTHenBookCreated() {
		var expectedBook = new Book("a234567890", "Title", "Author", 9.90);
		webClient
				.post()
				.uri("/api/v1/books")
				.bodyValue(expectedBook)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(Book.class).value(
						actualBook ->{
							assertThat(actualBook).isNotNull();
							assertThat(actualBook.isbn())
									.isEqualTo(expectedBook.isbn());
						}
				);

	}

}
