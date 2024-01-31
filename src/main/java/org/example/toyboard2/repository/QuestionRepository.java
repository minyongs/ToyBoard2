package org.example.toyboard2.repository;

import org.example.toyboard2.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {


}
