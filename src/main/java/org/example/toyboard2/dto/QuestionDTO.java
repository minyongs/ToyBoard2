package org.example.toyboard2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.toyboard2.entity.Question;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String title;
    private String content;

    private LocalDateTime createdAt;

    public static Question toEntity(QuestionDTO questionDTO){
        Question question = new Question();
        question.setId(question.getId());
        question.setTitle(questionDTO.getTitle());
        question.setContent(questionDTO.getContent());
        question.setCreatedAt(questionDTO.getCreatedAt());
        return question;
    }

}



