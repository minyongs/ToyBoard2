package org.example.toyboard2.controller;


import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;

import org.example.toyboard2.service.AnswerService;
import org.example.toyboard2.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;



    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable Long id, @RequestParam(value = "content") String content, Principal principal) {
        Long id2 = questionService.getDetail(id).getId(); // Question dto 를 id 값으로 찾아옴

        answerService.create(id2, content); // 답변 생성
        return String.format("redirect:/question/detail/%s", id);
    }

}
