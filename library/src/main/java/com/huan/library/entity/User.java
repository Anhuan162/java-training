package com.huan.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Users")
public class User {
  @Id private int userId;

  @NonNull
  private String name;
  private String role;
  private String email;

  @OneToMany(mappedBy = "user")
  private List<Loan> loans;
}
