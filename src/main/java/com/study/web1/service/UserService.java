package com.study.web1.service;

import com.study.web1.exception.UserNotFoundException;
import com.study.web1.vo.UserVo;
import com.study.web1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> findAll() {
        return userMapper.findAll();
    }

    public UserVo findById(Long id) {
        UserVo user = userMapper.findById(id);
        if (user == null)
            throw new UserNotFoundException("Not exist user: id = " + id);
        return user;
    }

    public void registerUser(UserVo user) {
        userMapper.registerUser(user);
    }

    public void updateUser(UserVo user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    public int countDuplicateUsername(Long id, String username) {
        return userMapper.countDuplicateUsername(id, username);
    }

    public int countDuplicateEmail(Long id, String email) {
        return userMapper.countDuplicateEmail(id, email);
    }
}