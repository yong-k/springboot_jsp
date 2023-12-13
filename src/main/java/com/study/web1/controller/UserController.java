package com.study.web1.controller;

import com.study.web1.exception.DuplicateEmailException;
import com.study.web1.exception.DuplicateUsernameException;
import com.study.web1.exception.InvaildEmailFormatException;
import com.study.web1.exception.MissingRequiredInfomationException;
import com.study.web1.service.UserService;
import com.study.web1.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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
        } catch (NoSuchElementException e) {
            model.addAttribute("message", "게시물이 삭제되었거나 다른 페이지로 변경되었습니다.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        }
        return "userDetail";
    }

    @GetMapping ("/users/register")
    public String registerForm() {
        return "userRegisterForm";
    }

    @PostMapping("/users")
    public String registerUser(Model model, UserVo user) {
        UserVo newUser;
        try {
            userService.registerUser(user);
            newUser = userService.findByUsername(user.getUsername());
        } catch (NoSuchElementException e) {
            model.addAttribute("message", "오류가 발생했습니다.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        } catch (MissingRequiredInfomationException e) {
            model.addAttribute("message", "필수 정보를 입력해주세요.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        } catch (InvaildEmailFormatException e) {
            model.addAttribute("message", "이메일 형식을 확인해주세요.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        } catch (DuplicateUsernameException e) {
            model.addAttribute("message", "사용할 수 없는 닉네임입니다.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        } catch (DuplicateEmailException e) {
            model.addAttribute("message", "사용할 수 없는 이메일입니다.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        }
        return "redirect:/users/" + newUser.getId();
    }

    @GetMapping("/users/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("user", userService.findById(id));
        } catch (NoSuchElementException e) {
            model.addAttribute("message", "게시물이 삭제되었거나 다른 페이지로 변경되었습니다.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        }
        return "userUpdateForm";
    }

    @PutMapping("/users/{id}")
    public String updateUser(Model model, UserVo user) {
        try {
            userService.updateUser(user);
        } catch (NoSuchElementException e) {
            model.addAttribute("message", "오류가 발생했습니다.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        } catch (MissingRequiredInfomationException e) {
            model.addAttribute("message", "필수 정보를 입력해주세요.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        } catch (InvaildEmailFormatException e) {
            model.addAttribute("message", "이메일 형식을 확인해주세요.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        } catch (DuplicateUsernameException e) {
            model.addAttribute("message", "사용할 수 없는 닉네임입니다.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        } catch (DuplicateEmailException e) {
            model.addAttribute("message", "사용할 수 없는 이메일입니다.");
            log.info("exception message={}", e.getMessage(), e);
            return "error/error";
        }
        return "redirect:/users/" + user.getId();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
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
