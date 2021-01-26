package com.cloudwalker.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "publishers")
public class Publisher {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private Date createdAt;
}
