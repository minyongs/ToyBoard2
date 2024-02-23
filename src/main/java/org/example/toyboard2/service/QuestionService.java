package org.example.toyboard2.service;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.AnswerDTO;
import org.example.toyboard2.dto.QuestionDTO;
import org.example.toyboard2.entity.Question;
import org.example.toyboard2.entity.SiteUser;
import org.example.toyboard2.exception.DataNotFoundException;
import org.example.toyboard2.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    //get일땐 가져오는 로직이니까 entity -> dto
    public Page<QuestionDTO> getList(Pageable pageable) {
        Page<Question> questionPage = questionRepository.findAll(pageable);
        return questionPage.map(question -> new QuestionDTO(
                question.getId(),
                question.getTitle(),
                question.getContent(),
                question.getCreatedAt(),
                question.getAuthor()


        ));
    }

    public QuestionDTO getDetail(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("질문을 찾을수 없습니다"));

        List<AnswerDTO> answerDTOList = question.getAnswer().stream()
                .map(answer -> new AnswerDTO(answer.getContent(), answer.getCreatedAt(), answer.getAuthor(), answer.getId())) // AnswerDTO에 author가 포함되어 있다면 이렇게 설정
                .collect(Collectors.toList());

        return new QuestionDTO(question.getId(), question.getTitle(), question.getContent(),
                question.getCreatedAt(), answerDTOList, question.getAuthor()); // author 정보 포함하여 QuestionDTO 생성
    }



    public void postQuestion(QuestionDTO questionDTO){
        Question question = QuestionDTO.toEntity(questionDTO);
        questionRepository.save(question);

    }

    @Transactional
    public void updateQuestion(Long id, QuestionDTO questionDTO) {
        // findById를 사용하여 업데이트할 질문 엔티티를 찾기
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 질문이 없습니다. id=" + id));

        // 찾은 질문 엔티티의 내용을 DTO로부터 받은 값으로 업데이트합니다.
        question.setTitle(questionDTO.getTitle());
        question.setContent(questionDTO.getContent());


    }

    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }




}
