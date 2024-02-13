package org.example.toyboard2.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;
import org.example.toyboard2.entity.Answer;
import org.example.toyboard2.entity.Question;
import org.example.toyboard2.entity.SiteUser;
import org.example.toyboard2.repository.AnswerRepository;
import org.example.toyboard2.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    //post -> repository에 저장하는 로직!
//    public void create(QuestionDTO questionDTO, String content) {
//        // Question 엔티티 조회
//        Question question = getQuestion(questionDTO);
//
//        // Answer 객체 생성 및 설정
//        Answer answer = new Answer();
//        answer.setContent(content);
//        answer.setCreatedAt(LocalDateTime.now());
//        answer.setQuestion(question);
//
//        // Answer 객체 저장
//        answerRepository.save(answer);
//    }

    private Question getQuestion(Long id) {
        return  questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 id의 질문이 없습니다: "));

    }

    public void create(Long id, String content, SiteUser author){

        Question question = getQuestion(id);

        Answer answer = new Answer(content, question,author);

        answerRepository.save(answer);


    }

}
