package com.huan.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Books")
public class Book {
  @Id private Integer bookId;

  private String title;

  private Integer totalCopies;

  private Integer availableCopies;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(mappedBy = "book")
  private List<Loan> loans;
}
