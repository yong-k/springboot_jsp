package com.study.web1.service;

import com.study.web1.exception.DuplicateEmailException;
import com.study.web1.exception.DuplicateUsernameException;
import com.study.web1.exception.InvaildEmailFormatException;
import com.study.web1.exception.MissingRequiredInfomationException;
import com.study.web1.vo.UserVo;
import com.study.web1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.study.web1.utils.ValidationRegex.isRegexEmail;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> findAll() {
        return userMapper.findAll();
    }

    public UserVo findById(Long id) {
        return userMapper.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not exist user: id = " + id));
    }

    public UserVo findByUsername(String username) {
        return userMapper.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("Not exist user: username = " + username));
    }

    public void registerUser(UserVo user) {
        if (user.getUsername() == null || user.getEmail() == null || user.getPassword() == null)
            throw new MissingRequiredInfomationException("Missing required information error.");

        if (!isRegexEmail(user.getEmail()))
            throw new InvaildEmailFormatException("Invalid email format error.");

        checkDuplicateUsername(user);
        checkDuplicateEmail(user);

        int result = userMapper.registerUser(user);

        // insert fail exception??
        /*
        if (result != 1)
            throw new ~~~;
        */
    }

    public void updateUser(UserVo user) {
        checkDuplicateUsername(user);
        checkDuplicateEmail(user);

        int result = userMapper.updateUser(user);

        // update fail exception??
        /*
        if (result != 1)
            throw new ~~;
        */
    }

    public void deleteUser(Long id) {
        int result = userMapper.deleteUser(id);

        // delete fail exception?
        /*
        if (result != 1)
            throw new ~~;
        */
    }

    public Integer countDuplicateUsername(Long id, String username) {
        return userMapper.countDuplicateUsername(id, username);
    }

    public Integer countDuplicateEmail(Long id, String email) {
        return userMapper.countDuplicateEmail(id, email);
    }

    public void checkDuplicateUsername(UserVo user) {
        if (userMapper.countDuplicateUsername(user.getId(), user.getUsername()) > 0)
            throw new DuplicateUsernameException("Duplicate username error: username = " + user.getUsername());
    }
    public void checkDuplicateEmail(UserVo user) {
        if (userMapper.countDuplicateEmail(user.getId(), user.getEmail()) > 0)
            throw new DuplicateEmailException("Duplicate email error: email = " + user.getEmail());
    }
}
