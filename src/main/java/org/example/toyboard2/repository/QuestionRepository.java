package org.example.toyboard2.repository;

import org.example.toyboard2.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Long> {

    // 모든 질문을 페이징 처리하여 조회
    Page<Question> findAll(Pageable pageable);

    // 제목에 특정 키워드가 포함된 질문만 페이징 처리하여 조회
    Page<Question> findByTitleContaining(String title, Pageable pageable);


}
