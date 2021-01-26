package com.cloudwalker.graphql.resolver;

import com.cloudwalker.graphql.model.Author;
import com.cloudwalker.graphql.model.Book;
import com.cloudwalker.graphql.model.Publisher;
import com.cloudwalker.graphql.repositories.AuthorRepository;
import com.cloudwalker.graphql.repositories.PublisherRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public BookResolver(AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElseThrow(null);
    }

    public Publisher getPublisher(Book book) {
        return publisherRepository.findById(book.getPublisher().getId()).orElseThrow(null);
    }
}
