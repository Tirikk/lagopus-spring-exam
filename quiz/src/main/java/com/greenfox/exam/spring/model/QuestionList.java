package com.greenfox.exam.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class QuestionList {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  @Column(columnDefinition = "LONGBLOB")
  ArrayList<Question> questions;

  public QuestionList() {
  }

  public QuestionList(ArrayList<Question> questions) {
    this.questions = questions;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(ArrayList<Question> questions) {
    this.questions = questions;
  }
}
