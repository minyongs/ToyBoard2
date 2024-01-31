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

    @AfterEach
    void clear(){
        questionRepository.deleteAllInBatch();
    }



    @Test
    void test1(){
        //given
        Question question = new Question("안녕하세요","이거 글 잘 써지는건가", LocalDateTime.now());
        Question question2 = new Question("안녕하세요2","이거 글 잘 써지는건가2", LocalDateTime.now());


        //when
        questionRepository.save(question);
        questionRepository.save(question2);



        //then
        Assertions.assertThat(questionRepository.findAll().size()).isEqualTo(2);


    }

}