package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.AnswerList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerListRepository extends CrudRepository<AnswerList, Long> {
}
