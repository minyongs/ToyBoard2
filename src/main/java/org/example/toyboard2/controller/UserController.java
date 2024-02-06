package org.example.toyboard2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.SiteUserDTO;
import org.example.toyboard2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/signup")
    public String getSignUp(Model model){
        model.addAttribute("siteUserDTO", new SiteUserDTO());
        return "signup_form";
    }

    @PostMapping("/user/signup")
    public String signUp(@Valid SiteUserDTO siteUserDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup_form";
        }

        if (!siteUserDTO.getPassword().equals(siteUserDTO.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        userService.create(siteUserDTO);

        return "redirect:/";

    }




}
