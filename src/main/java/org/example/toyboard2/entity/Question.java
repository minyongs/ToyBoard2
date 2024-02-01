package org.example.toyboard2.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.toyboard2.dto.QuestionDTO;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    public Question(Long id,String title,String content,LocalDateTime createdAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition ="TEXT") // 글자 수 제한 x
    private String content;

    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "question" ,fetch = FetchType.LAZY,cascade = CascadeType.REMOVE) // 글이 삭제되면 댓글도 삭제
    private List<Answer> answer;

    public static QuestionDTO toDto(Question question){
        return new QuestionDTO(question.getId(), question.getTitle(), question.getContent(), question.getCreatedAt());
    }
}
