package org.example.toyboard2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.toyboard2.entity.Answer;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AnswerDTO {

    private String content;
    private LocalDateTime createdAt;


    public static Answer toEntity(AnswerDTO answerDTO){
        Answer answer = new Answer();
        answer.setContent(answerDTO.getContent());
        answer.setCreatedAt(answerDTO.getCreatedAt());
        return answer;

    }

}
