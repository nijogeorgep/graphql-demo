package com.cloudwalker.graphql;

import com.cloudwalker.graphql.model.Author;
import com.cloudwalker.graphql.model.Book;
import com.cloudwalker.graphql.model.Publisher;
import com.cloudwalker.graphql.repositories.AuthorRepository;
import com.cloudwalker.graphql.repositories.BookRepository;
import com.cloudwalker.graphql.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GraphqlApplication implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final PublisherRepository publisherRepository;
	private final BookRepository bookRepository;

	@Autowired
	public GraphqlApplication(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = new ArrayList<Book>();
		books.add(Book.builder()
				.id("a")
				.title("India in British Rule")
				.isbn("ISBN-8737434239")
				.minutesRead(90)
				.price(200)
				.publisher(Publisher.builder()
						.id("a1")
						.name("DC Books")
						.phone("04842487537")
						.email("info@dcbooks.com")
						.createdAt(new Date()).build())
				.author(Author.builder()
						.id("ab1")
						.name("Sasi Tharoor")
						.age(53).nationality("Indian")
						.createdAt(new Date()).build())
				.createdAt(new Date())
				.build());

		books.add(Book.builder()
				.id("b")
				.title("Tales of Rural India")
				.isbn("ISBN-83756347856")
				.minutesRead(190)
				.price(2100)
				.publisher(Publisher.builder()
						.id("b1")
						.name("Pearson Publishing")
						.phone("04842487577")
						.email("info@pearson.com")
						.createdAt(new Date()).build())
				.author(Author.builder()
						.id("bc1")
						.name("Tim Cook")
						.age(54)
						.nationality("Indian")
						.createdAt(new Date()).build())
				.build());

		books.add(Book.builder()
				.id("c")
				.title("Hinduisam Vs Hinduthva")
				.isbn("ISBN-874364782")
				.minutesRead(290)
				.price(2500)
				.publisher(Publisher.builder()
						.id("c1")
						.name("United Publishers")
						.phone("048424876477")
						.email("info@unitedpublishers.com")
						.createdAt(new Date()).build())
				.author(Author.builder()
						.id("cd1")
						.name("Dev Nadar")
						.age(55)
						.nationality("Indian")
						.createdAt(new Date()).build())
				.build());

		books.add(Book.builder()
				.id("d")
				.title("Importance Learning History")
				.isbn("ISBN-2948729384")
				.minutesRead(390).price(2000)
				.publisher(Publisher.builder()
						.id("d1")
						.name("SK Printings")
						.phone("048424854677")
						.email("info@skp.com")
						.createdAt(new Date()).build())
				.author(Author.builder()
						.id("de1")
						.name("Hima Kulkarni")
						.age(56)
						.nationality("Indian")
						.createdAt(new Date()).build())
				.build());

		books.forEach(book -> {
			bookRepository.save(book);
		});
	}
}
