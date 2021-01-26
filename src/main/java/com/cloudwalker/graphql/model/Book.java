package com.cloudwalker.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String isbn;
    private double price;
    private Integer minutesRead;
    private Date createdAt;
    @DBRef
    private Author author;
    @DBRef
    private Publisher publisher;
}
