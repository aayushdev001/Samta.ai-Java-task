package com.samta.radomquestionanswer.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NextQuestionResponseDTO
{
    String correctAnswer;
    NextQuestion nextQuestion;
}
