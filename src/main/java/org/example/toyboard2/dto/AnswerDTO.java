package org.example.toyboard2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.toyboard2.entity.Answer;
import org.example.toyboard2.entity.SiteUser;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AnswerDTO {

    private String content;
    private LocalDateTime createdAt;
    private SiteUser author;
    private Long id;



    public static Answer toEntity(AnswerDTO answerDTO){
        Answer answer = new Answer();
        answer.setId(answerDTO.getId());
        answer.setContent(answerDTO.getContent());
        answer.setCreatedAt(answerDTO.getCreatedAt());
        answer.setAuthor(answerDTO.getAuthor());

        return answer;

    }

}
