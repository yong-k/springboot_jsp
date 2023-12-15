package com.study.web1.controller;

import com.study.web1.exception.UserNotFoundException;
import com.study.web1.service.UserService;
import com.study.web1.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.study.web1.exception.Errcode.*;

@Slf4j
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
    public String findById(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("user", userService.findById(id));
            return "userDetail";
        } catch (UserNotFoundException e) {
            model.addAttribute("errcode", NOT_EXIST_USER);
            log.error("Error in UserController.findById()", e);
            return "error/error";
        } catch (Exception e) {
            log.error("Error in UserController.findById()", e);
            return "error/error";
        }
    }

    @GetMapping ("/users/register")
    public String registerForm() {
        return "userRegisterForm";
    }

    @PostMapping("/users")
    public String registerUser(Model model, UserVo user) {
        try {
            userService.registerUser(user);
            return "redirect:/users";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errcode", SYSTEM_PROBLEM);
            log.error("Error in UserController.registerUser()", e);
            return "error/error";
        } catch (Exception e) {
            log.error("Error in UserController.registerUser()", e);
            return "error/error";
        }
    }

    @GetMapping("/users/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("user", userService.findById(id));
            return "userUpdateForm";
        } catch (UserNotFoundException e) {
            model.addAttribute("errcode", NOT_EXIST_USER);
            log.error("Error in UserController.updateForm()", e);
            return "error/error";
        } catch (Exception e) {
            log.error("Error in UserController.updateForm()", e);
            return "error/error";
        }
    }

    @PostMapping("/users/update")
    public String updateUser(Model model, UserVo user) {
        try {
            userService.updateUser(user);
            return "redirect:/users/" + user.getId();
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errcode", SYSTEM_PROBLEM);
            log.error("Error in UserController.updateUser()", e);
            return "error/error";
        } catch (Exception e) {
            log.error("Error in UserController.updateUser()", e);
            return "error/error";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(Model model, @PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return "redirect:/users";
        } catch (Exception e) {
            log.error("Error in UserController.deleteUser()", e);
            return "error/error";
        }
    }

    @GetMapping("/checkusername")
    public @ResponseBody Integer checkDuplicateUsername(@RequestParam(required = false) Long id, @RequestParam String username) {
        return userService.countDuplicateUsername(id, username);
    }

    @GetMapping("/checkemail")
    public @ResponseBody Integer checkDuplicateEmail(@RequestParam(required = false) Long id, @RequestParam String email) {
        return userService.countDuplicateEmail(id, email);
    }
}
