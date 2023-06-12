package com.samta.radomquestionanswer.Controller;

import com.samta.radomquestionanswer.DTOs.NextQuestionRequestDTO;
import com.samta.radomquestionanswer.DTOs.NextQuestionResponseDTO;
import com.samta.radomquestionanswer.DTOs.QuestionPlayDTO;
import com.samta.radomquestionanswer.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    @GetMapping("/fetch-questions")
    public String fetchQuestions()
    {
        return questionService.fetchQuestions();
    }

    @GetMapping("/play/{id}")
    public QuestionPlayDTO play(@PathVariable int id)
    {
        return questionService.play(id);
    }

    @GetMapping("/next")
    public NextQuestionResponseDTO next (@RequestBody NextQuestionRequestDTO nextQuestionRequestDTO)
    {
        return questionService.next(nextQuestionRequestDTO);
    }
}
