package com.samta.radomquestionanswer.Respositories;

import com.samta.radomquestionanswer.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>
{
}
