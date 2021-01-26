package com.cloudwalker.graphql.resolver;

import com.cloudwalker.graphql.model.Author;
import com.cloudwalker.graphql.model.Book;
import com.cloudwalker.graphql.model.Publisher;
import com.cloudwalker.graphql.repositories.AuthorRepository;
import com.cloudwalker.graphql.repositories.BookRepository;
import com.cloudwalker.graphql.repositories.PublisherRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private BookRepository bookRepository;

    @Autowired
    public Mutation(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(String name, Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);

        authorRepository.save(author);
        return author;
    }

    public Publisher createPublisher(String name) {
        Publisher publisher = new Publisher();
        publisher.setName(name);

        publisherRepository.save(publisher);
        return publisher;
    }

    public Book createBook(String title) {
        Book book = new Book();
        book.setTitle(title);

        bookRepository.save(book);
        return book;
    }

}
