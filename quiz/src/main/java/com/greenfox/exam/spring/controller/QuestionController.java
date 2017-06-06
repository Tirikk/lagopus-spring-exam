package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionList;
import com.greenfox.exam.spring.repository.QuestionListRepository;
import com.greenfox.exam.spring.repository.QuestionRepository;
import com.greenfox.exam.spring.service.QuestionPicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

  @Autowired
  QuestionRepository questionRepo;

  @Autowired
  QuestionListRepository questionListRepo;

  @GetMapping("/questions")
  public QuestionList getQuestions() {
    List allQuestions = (List)questionRepo.findAll();
    QuestionList fiveQuestions = new QuestionList(QuestionPicker.chooseFiveRandom(allQuestions));
//    questionListRepo.save(fiveQuestions);
    return fiveQuestions;
  }
}
