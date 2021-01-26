package com.cloudwalker.graphql.repositories;

import com.cloudwalker.graphql.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, String> {

}
