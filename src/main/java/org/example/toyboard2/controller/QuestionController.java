package org.example.toyboard2.controller;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;

import org.example.toyboard2.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/list")
    public String list(Model model){
        List<QuestionDTO> list = questionService.getList();
        model.addAttribute("questionList", list);
        return "question_list";

    }


}
