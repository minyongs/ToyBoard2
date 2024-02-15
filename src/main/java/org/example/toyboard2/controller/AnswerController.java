package org.example.toyboard2.controller;


import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;

import org.example.toyboard2.entity.SiteUser;
import org.example.toyboard2.service.AnswerService;
import org.example.toyboard2.service.QuestionService;
import org.example.toyboard2.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final UserService userService;


    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable Long id, @RequestParam(value = "content") String content, Principal principal) {
        Long id2 = questionService.getDetail(id).getId();
        SiteUser user = userService.getUser(principal.getName());

        answerService.create(id2, content,user); // 답변 생성
        return String.format("redirect:/question/detail/%s", id);
    }
    @PostMapping("/delete/{id}")
    public String deleteAnswer(@PathVariable Long id) {

        Long questionId = answerService.findQuestionIdByAnswerId(id);


        answerService.delete(id);

        // 댓글이 속한 질문의 상세 페이지로 리다이렉트
        return "redirect:/question/detail/" + questionId;
    }



}
