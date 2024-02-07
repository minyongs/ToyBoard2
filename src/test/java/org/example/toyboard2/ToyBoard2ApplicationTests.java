package org.example.toyboard2;

import org.example.toyboard2.dto.QuestionDTO;
import org.example.toyboard2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ToyBoard2ApplicationTests {
    @Autowired
    private QuestionService questionService ;
    @Test
    void testJpa() {
        for (Long i = 1L; i <= 20; i++) {
            QuestionDTO questionDTO = new QuestionDTO(i,"테스트 데이터입니다 "+i,"ㅎㅎ", LocalDateTime.now());
            questionService.postQuestion(questionDTO);

        }


    }


}
