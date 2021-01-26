package com.cloudwalker.graphql.repositories;

import com.cloudwalker.graphql.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, String> {

}
