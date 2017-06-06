package com.greenfox.exam.spring.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class AnswerList {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  @Column(columnDefinition = "LONGBLOB")
  ArrayList<Answer> answers;

  public AnswerList() {
  }

  public AnswerList(ArrayList<Answer> answers) {
    this.answers = answers;
  }

  public ArrayList<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(ArrayList<Answer> answers) {
    this.answers = answers;
  }
}
