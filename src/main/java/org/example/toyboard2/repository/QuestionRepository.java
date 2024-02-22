package org.example.toyboard2.repository;

import jakarta.persistence.LockModeType;
import org.example.toyboard2.dto.QuestionDTO;
import org.example.toyboard2.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Long> {

    // 모든 질문을 페이징 처리하여 조회
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Page<Question> findAll(Pageable pageable);

    // 제목에 특정 키워드가 포함된 질문만 페이징 처리하여 조회
    Page<Question> findByTitleContaining(String title, Pageable pageable);


    List<Question> findAllByAuthorUsername(String username);



}
