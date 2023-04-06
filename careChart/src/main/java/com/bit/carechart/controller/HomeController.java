package com.bit.carechart.controller;

import com.bit.carechart.model.UserDTO;
import com.bit.carechart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showIndex(HttpSession session, Model model) {
        System.out.println("여긴 테스트 구역");

        List<UserDTO> userList = userService.selectAll();

        for(UserDTO u : userList) {
            System.out.println(u);
        }

        return "index.html";


//        return "redirect:/mypage/showBasket";
    }
}
