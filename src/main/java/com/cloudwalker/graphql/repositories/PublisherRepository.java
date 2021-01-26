package com.cloudwalker.graphql.repositories;

import com.cloudwalker.graphql.model.Publisher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PublisherRepository extends PagingAndSortingRepository<Publisher, String> {

}
