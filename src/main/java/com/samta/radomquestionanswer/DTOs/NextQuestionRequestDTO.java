package com.samta.radomquestionanswer.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NextQuestionRequestDTO
{
    int id;
    String answer;
}
