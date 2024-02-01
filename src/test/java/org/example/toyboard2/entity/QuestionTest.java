package org.example.toyboard2.entity;

import org.assertj.core.api.Assertions;
import org.example.toyboard2.repository.QuestionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class QuestionTest {

    @Autowired
    private QuestionRepository questionRepository;





    @Test
    void test1(){
        //given
        Question question = new Question(1L,"안녕하세요","이거 글 잘 써지는건가", LocalDateTime.now());
        questionRepository.save(question);


    }

}