package org.example.toyboard2.controller;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;

import org.example.toyboard2.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model){
        List<QuestionDTO> list = questionService.getList();
        model.addAttribute("questionList", list);
        return "question_list";

    }

    @GetMapping("/detail/{id}")
    public String getDetail(Model model, @PathVariable Long id){

        QuestionDTO questionDTO = questionService.getDetail(id);
        model.addAttribute("questionDetail",questionDTO);
        return "question_detail";


    }


}
