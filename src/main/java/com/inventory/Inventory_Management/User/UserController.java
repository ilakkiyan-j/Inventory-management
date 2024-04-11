package com.inventory.Inventory_Management.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;

@Controller
public class UserController {

    @GetMapping
    public String showLoginForm() {
        return "Login";
    }

    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public String login(
            @RequestBody MultiValueMap<String, String > data,
            HttpServletRequest request
    ) {
        String userId = data.getFirst("username");
        String password = data.getFirst("password");
        System.out.println(userId + ":" + password);
        request.getSession().setAttribute("userId", userId);
        return "redirect:/main";
    }
}
