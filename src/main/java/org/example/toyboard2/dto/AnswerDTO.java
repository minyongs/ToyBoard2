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
    private SiteUser user;



    public static Answer toEntity(AnswerDTO answerDTO){
        Answer answer = new Answer();
        answer.setContent(answerDTO.getContent());
        answer.setCreatedAt(answerDTO.getCreatedAt());
        answer.setAuthor(answerDTO.user);

        return answer;

    }

}
