package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.*;
import com.greenfox.exam.spring.repository.AnswerRepository;
import com.greenfox.exam.spring.repository.QuestionListRepository;
import com.greenfox.exam.spring.repository.QuestionRepository;
import com.greenfox.exam.spring.service.QuestionPicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {

  @Autowired
  QuestionRepository questionRepo;

  @Autowired
  QuestionListRepository questionListRepo;

  @Autowired
  AnswerRepository answerRepository;

  ArrayList<Question> questions;

  @GetMapping("/questions")
  public QuestionList getQuestions() {
    List allQuestions = (List)questionRepo.findAll();
    questions = QuestionPicker.chooseFiveRandom(allQuestions);
    QuestionList fiveQuestions = new QuestionList(questions);
//    questionListRepo.save(fiveQuestions);
    return fiveQuestions;
  }

  @PostMapping("/answers")
  public ProjectList postAnswers(@RequestBody AnswerList answerList) {
    ArrayList<Answer> answers = answerList.getAnswers();
    boolean isCorrect = true;
    for (Answer answer : answers) {
      if (answer.getId() != questions.get(answers.indexOf(answer)).getId() || answer.getAnswer().equals
              (answerRepository.findOne(answer.getId()).getAnswer())) {
        isCorrect = false;
      }
    }
    RestTemplate rt = new RestTemplate();

    if (isCorrect) {
      return rt.postForObject("https://springexamserver.herokuapp.com/projects/sabers", "projectList", ProjectList.class);
    } else {
      return new ProjectList();
    }
  }
}
