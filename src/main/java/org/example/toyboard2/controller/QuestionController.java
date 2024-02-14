package org.example.toyboard2.controller;

import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.QuestionDTO;

import org.example.toyboard2.entity.SiteUser;
import org.example.toyboard2.service.QuestionService;

import org.example.toyboard2.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 10, sort = "createdAt",direction = Sort.Direction.DESC) Pageable pageable){
        Page<QuestionDTO> page = questionService.getList(pageable);
        model.addAttribute("questionPage", page);
        return "question_list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/detail/{id}")
    public String getDetail(Model model, @PathVariable Long id){


        QuestionDTO questionDTO = questionService.getDetail(id);// questionDTO 객체에 상세페이지 정보 넘김
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        model.addAttribute("currentUserName", currentUserName);

        model.addAttribute("questionDetail",questionDTO); //questionDetail 이란 객체로 모델에 전달
        return "question_detail"; //모델이 뷰에게 전달




    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/post")
    public String postGet(){
        return "/post";
    }


    @PreAuthorize("isAuthenticated()")
    @PostMapping("/post_question")
    public String postQuestion(Model model, @ModelAttribute QuestionDTO questionDTO, Principal principal){
        SiteUser user = userService.getUser(principal.getName());
        questionDTO.setAuthor(user);

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
