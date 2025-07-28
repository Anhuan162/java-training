package com.huan.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Categories")
public class Category {
  @Id private Integer categoryId;

  private String name;

  @OneToMany(mappedBy = "category")
  private List<Book> books;
}
