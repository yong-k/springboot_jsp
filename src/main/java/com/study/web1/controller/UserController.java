package com.study.web1.controller;

import com.study.web1.service.UserService;
import com.study.web1.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping ("/users/save")
    public String saveForm() {
        return "userInsertForm";
    }

    @PostMapping("/users")
    public String saveUser(UserVo user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String findById(Model model, @PathVariable("id") Long id) {
        // users id 직접 치고 들어왔을 때 없을 경우 예외처리
        model.addAttribute("user", userService.findById(id));
        return "userDetail";
    }

    @GetMapping("/users/update/{id}")
    public String updateForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "userUpdateForm";
    }

    @PutMapping("/users/{id}")
    public String updateUser(UserVo user) {
        userService.updateUser(user);
        return "redirect:/users/" + user.getId();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/header")
    public String header() {
        return "header";
    }

    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }
}
