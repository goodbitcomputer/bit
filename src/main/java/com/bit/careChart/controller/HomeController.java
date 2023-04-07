package com.bit.careChart.controller;

import com.bit.careChart.model.UserDTO;
import com.bit.careChart.service.UserService;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController implements ErrorController {
    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showIndex() {
        System.out.println("여긴 테스트 구역");

        List<UserDTO> userList = userService.selectAll();

        for(UserDTO u : userList) {
            System.out.println(u);
        }

        return "index,html";


//        return "redirect:/mypage/showBasket";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        System.out.println("로그인 페이지");
        return "login.html";
    }

    @PostMapping("/doLogin")
    public String auth(HttpSession session, Model model, UserDTO attempt) {
        UserDTO result = userService.auth(attempt);

        if (result != null) {
            session.setAttribute("logIn", result);
            System.out.println("Log In Success");
            return "redirect:/";
        } else {
            model.addAttribute("message", "로그인 정보를 다시 확인해주세요.");
            System.out.println("Log In Fail");
            return "login.html";
        }
    }

    public String getErrorPath() {
        return "/error";
    }
}
