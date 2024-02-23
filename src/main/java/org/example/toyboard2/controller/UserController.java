package org.example.toyboard2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.toyboard2.dto.ProfileDTO;
import org.example.toyboard2.dto.SiteUserDTO;
import org.example.toyboard2.entity.SiteUser;
import org.example.toyboard2.service.ProfileService;
import org.example.toyboard2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ProfileService profileService;

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

    @GetMapping("/user/login")
    public String loginPage() {
        return "login_form";
    }

    // 로그인 에러 처리를 위한 메소드
    @GetMapping("/user/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login_form"; // 로그인 폼 페이지의 이름을 반환하며, 로그인 에러 플래그를 모델에 추가
    }


    @GetMapping("/user/profile")
    public String profile(Model model , Principal principal){
        SiteUser user = userService.getUser(principal.getName());
        ProfileDTO profileDTO = profileService.profileDetail(user);
        model.addAttribute("profileDetail",profileDTO);
        return "profile";

    }



}
