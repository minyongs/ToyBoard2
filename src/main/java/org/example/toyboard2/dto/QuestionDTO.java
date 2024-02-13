package org.example.toyboard2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.toyboard2.entity.Answer;
import org.example.toyboard2.entity.Question;
import org.example.toyboard2.entity.SiteUser;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDTO {
    private Long id;
    private String title;
    private String content;

    private LocalDateTime createdAt;
    private List<AnswerDTO> answerDTOList; // 하나의 글에 여러개의 댓글이 달릴수 있으므로 AnswerDTO 들을 받을수 있는 리스트 필요
    private SiteUser author;


    public static Question toEntity(QuestionDTO questionDTO){
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setTitle(questionDTO.getTitle());
        question.setContent(questionDTO.getContent());
        question.setCreatedAt(questionDTO.getCreatedAt());
        question.setAuthor(questionDTO.getAuthor());
        return question;
    }
    public QuestionDTO(Long id, String title, String content, LocalDateTime createdAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt =createdAt;
    }

    public QuestionDTO(Long id, String title, String content, LocalDateTime createdAt, List<AnswerDTO> answerList,SiteUser author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
        this.answerDTOList = answerList;
    }

    public QuestionDTO(Long id, String title, String content, LocalDateTime createdAt,SiteUser author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }


}



