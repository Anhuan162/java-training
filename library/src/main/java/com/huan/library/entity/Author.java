package com.huan.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Authors")
public class Author {
  @Id private Integer authorId;

  private String name;

  @OneToMany(mappedBy = "author")
  private List<Book> books;
}
