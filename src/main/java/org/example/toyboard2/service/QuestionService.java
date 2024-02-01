package org.example.toyboard2.service;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;
import org.example.toyboard2.entity.Question;
import org.example.toyboard2.exception.DataNotFoundException;
import org.example.toyboard2.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;


    public List<QuestionDTO> getList() {
        return questionRepository.findAll().stream()
                .map(question -> new QuestionDTO(
                        question.getId(),
                        question.getTitle(),
                        question.getContent(),
                        question.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public QuestionDTO getDetail(Long id){
        Optional<Question> byId = questionRepository.findById(id);
        if(byId.isPresent()){
            Question question = byId.get();
            return new QuestionDTO(question.getId(), question.getTitle(), question.getContent(),question.getCreatedAt());

        }else{
            throw new DataNotFoundException("질문을 찾을수 없습니다");
        }

    }

}
