package org.example.toyboard2.service;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.ProfileDTO;
import org.example.toyboard2.dto.QuestionDTO;
import org.example.toyboard2.entity.Question;
import org.example.toyboard2.entity.SiteUser;
import org.example.toyboard2.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final QuestionRepository questionRepository;

    public ProfileDTO profileDetail(SiteUser user){
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setUserName(user.getUsername());
        List<Question> questions = questionRepository.findAllByAuthorUsername(profileDTO.getUserName());

        List<QuestionDTO> questionDTOS = questions.stream().map(question -> {
            QuestionDTO dto = new QuestionDTO();
            dto.setId(question.getId());
            dto.setTitle(question.getTitle());
            dto.setContent(question.getContent());
            // 필요한 다른 필드도 여기에 매핑
            return dto;
        }).toList();

        profileDTO.setQuestionDTOS(questionDTOS);
        return profileDTO;
    }


}
