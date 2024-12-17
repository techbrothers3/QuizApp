package com.techbrothers3.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techbrothers3.test.Model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
