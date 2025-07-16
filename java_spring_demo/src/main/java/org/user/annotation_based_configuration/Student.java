package org.user.annotation_based_configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Student {

  private int id;
  private MathCheat mathCheat;

  // Constructor for Dependency Injection
  @Autowired
  public Student(@Value("123") int id, MathCheat mathCheat) {
    this.id = id;
    this.mathCheat = mathCheat;
  }

  public void cheating() {
    System.out.println("My ID is: " + id);
    mathCheat.mathCheating();
  }
}
