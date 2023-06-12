package com.samta.radomquestionanswer.Service;

import com.samta.radomquestionanswer.DTOs.NextQuestion;
import com.samta.radomquestionanswer.DTOs.NextQuestionRequestDTO;
import com.samta.radomquestionanswer.DTOs.NextQuestionResponseDTO;
import com.samta.radomquestionanswer.DTOs.QuestionPlayDTO;
import com.samta.radomquestionanswer.Models.Question;
import com.samta.radomquestionanswer.Respositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuestionService
{
    @Autowired
    QuestionRepository questionRepository;

    public String fetchQuestions()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jservice.io/api/random";
        for(int i=0; i<5; i++)
        {
            Question[] response = restTemplate.getForObject(url, Question[].class);
            Question question = new Question();
            question.setId(response[0].getId());
            question.setQuestion(response[0].getQuestion());
            question.setAnswer(response[0].getAnswer());
            questionRepository.save(question);
        }
        return "Success";
    }

    public QuestionPlayDTO play(int id)
    {
        Question question = questionRepository.findById(id).get();
        QuestionPlayDTO questionPlayDTO = new QuestionPlayDTO(question.getId(), question.getQuestion());
        return questionPlayDTO;
    }

    public NextQuestionResponseDTO next(NextQuestionRequestDTO nextQuestionRequestDTO)
    {
        Question question = questionRepository.findById(nextQuestionRequestDTO.getId()).get();
        NextQuestion nextQuestion = new NextQuestion();
        List<Question> questionList = questionRepository.findAll();
        boolean flag = true;
        int i=0;
        for(Question q : questionList)
        {
             i++;
             if(q.getId() == nextQuestionRequestDTO.getId())
                break;
        }
        nextQuestion.setId(questionList.get(i).getId());
        nextQuestion.setQuestion(questionList.get(i).getQuestion());
        NextQuestionResponseDTO nextQuestionResponseDTO = new NextQuestionResponseDTO(question.getAnswer(), nextQuestion);
        return nextQuestionResponseDTO;
    }
}
