package com.cloudwalker.graphql.resolver;

import com.cloudwalker.graphql.model.Author;
import com.cloudwalker.graphql.model.Book;
import com.cloudwalker.graphql.model.Publisher;
import com.cloudwalker.graphql.repositories.AuthorRepository;
import com.cloudwalker.graphql.repositories.BookRepository;
import com.cloudwalker.graphql.repositories.PublisherRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private BookRepository bookRepository;

    @Autowired
    public Query(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public long countPublishers() {
        return publisherRepository.count();
    }

    public long countBooks() {
        return bookRepository.count();
    }
}
