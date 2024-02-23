package org.example.toyboard2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MinigameController {

    @GetMapping("/minigamelist")
    public String minigameList(){
        return "minigamelist";
    }

    @GetMapping("/minigame1")
    public String minigame1(){
        return "minigame1";
    }
}
