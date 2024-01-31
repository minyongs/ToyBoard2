package org.example.toyboard2.service;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;
import org.example.toyboard2.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;


    public List<QuestionDTO> getList() {
        return questionRepository.findAll().stream()
                .map(question -> new QuestionDTO(
                        question.getTitle(),
                        question.getContent(),
                        question.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public void post(QuestionDTO questionDTO){

    }

}
