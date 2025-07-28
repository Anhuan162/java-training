package com.huan.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Loans")
public class Loan {
  @Id private Integer loanId;

  private LocalDate borrowDate;
  private LocalDate returnDate;
  private LocalDate actualReturn;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;

  @OneToOne(mappedBy = "loan", cascade = CascadeType.ALL)
  private Fine fine;

}
