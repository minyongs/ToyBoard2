package org.example.toyboard2.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;
import org.example.toyboard2.entity.Answer;
import org.example.toyboard2.entity.Question;
import org.example.toyboard2.repository.AnswerRepository;
import org.example.toyboard2.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    //post 는 보내는 로직 dto -> entity
    public void create(QuestionDTO questionDTO, String content) {
        // Question 엔티티 조회
        Question question = questionRepository.findById(questionDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + questionDTO.getId()));

        // Answer 객체 생성 및 설정
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreatedAt(LocalDateTime.now());
        answer.setQuestion(question);

        // Answer 객체 저장
        answerRepository.save(answer);
    }

}
