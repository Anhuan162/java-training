package com.huan.library.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Fines")
public class Fine {
  @Id private Integer fineId;

  private BigDecimal amount;

  private String paid;

  @OneToOne
  @JoinColumn(name = "loan_id")
  private Loan loan;

}
