package org.example.toyboard2.controller;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;

import org.example.toyboard2.service.QuestionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 10, sort = "createdAt") Pageable pageable){
        Page<QuestionDTO> page = questionService.getList(pageable);
        model.addAttribute("questionPage", page);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(Model model, @PathVariable Long id){

        QuestionDTO questionDTO = questionService.getDetail(id); // questionDTO 객체에 상세페이지 정보 넘김
        model.addAttribute("questionDetail",questionDTO); //questionDetail 이란 객체로 모델에 전달
        return "question_detail"; //모델이 뷰에게 전달


    }

    @GetMapping("/post")
    public String postGet(){
        return "/post";
    }

    @PostMapping("/post_question")
    public String postQuestion(Model model, @ModelAttribute QuestionDTO questionDTO){
        questionService.postQuestion(questionDTO);
        return "redirect:/question/list";

    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable Long id,Model model){
        model.addAttribute("questionDetail",questionService.getDetail(id));

        return "update";

    }

    @PostMapping("/update/{id}")
    public String updateQuestion(@PathVariable Long id, @ModelAttribute QuestionDTO questionDTO) {
        questionService.updateQuestion(id, questionDTO);
        return "redirect:/question/list";
    }







    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return "redirect:/question/list";
    }




}
