package org.example.toyboard2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.toyboard2.dto.AnswerDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;


    public static AnswerDTO toDto(Answer answer){
        return new AnswerDTO(answer.getContent(), answer.getCreatedAt());

    }





}
