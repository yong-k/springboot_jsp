package com.study.web1.controller;

import com.study.web1.exception.BaseException;
import com.study.web1.exception.InvaildEmailFormatException;
import com.study.web1.service.UserService;
import com.study.web1.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.study.web1.response.BaseResponseStatus.*;
import static com.study.web1.utils.ValidationRegex.isRegexEmail;

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

    @GetMapping("/users/{id}")
    public String findById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "userDetail";
    }

    @GetMapping ("/users/save")
    public String saveForm() {
        return "userInsertForm";
    }

    @PostMapping("/users")
    public String saveUser(UserVo user) {
        try {
            userService.saveUser(user);
            return "redirect:/users";
        } catch (InvaildEmailFormatException e) {
            return "redirect:/invalidEmailPage";
        } catch (Exception e) {
            return "error";
        }
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

    @PostMapping("/checkusername")
    public @ResponseBody Integer checkUsername(@RequestParam(name = "id", required = false) Long id, @RequestParam("username") String username) {
        return userService.countUsername(id, username);
    }

    @PostMapping("/checkemail")
    public @ResponseBody Integer checkEmail(@RequestParam(name = "id", required = false) Long id, @RequestParam("email") String email) {
        return userService.countEmail(id, email);
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
