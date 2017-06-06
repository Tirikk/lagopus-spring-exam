package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionPicker {

  public static ArrayList<Question> chooseFiveRandom(List<Question> allQuestions) {
    ArrayList<Question> randomFive = new ArrayList<>();
    while (randomFive.size() < 5) {
      Question question = allQuestions.get((int)(Math.random() * allQuestions.size()));
      if (!randomFive.contains(question)) {
        randomFive.add(question);
      }
    }
    return randomFive;
  }
}
