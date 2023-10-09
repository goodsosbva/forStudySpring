package com.example.SpringModelSample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloModelController {
    @GetMapping("modal")
    public String helloView(Model model) {
        // model에 데이터를 저장
        model.addAttribute("msg", "타임리프!!!");

        // 반환값으로 뷰 이름을 돌려줌
        return "helloThymeleaf";
    }
}
