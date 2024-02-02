package org.example.toyboard2.service;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.AnswerDTO;
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

    //get일땐 가져오는 로직이니까 entity -> dto
    public List<QuestionDTO> getList() {
        return questionRepository.findAll().stream()
                .map(question -> new QuestionDTO(
                        question.getId(),
                        question.getTitle(),
                        question.getContent(),
                        question.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public QuestionDTO getDetail(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("질문을 찾을수 없습니다"));

        List<AnswerDTO> answerDTOList = question.getAnswer().stream()
                .map(answer -> new AnswerDTO(answer.getContent(), answer.getCreatedAt()))
                .collect(Collectors.toList());

        return new QuestionDTO(question.getId(), question.getTitle(), question.getContent(),
                question.getCreatedAt(), answerDTOList);
    }


    public void postQuestion(QuestionDTO questionDTO){
        Question question = QuestionDTO.toEntity(questionDTO);
        questionRepository.save(question);

    }

    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }


}
