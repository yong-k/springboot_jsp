package com.study.web1.service;

import com.study.web1.mapper.UserMapper;
import com.study.web1.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> findAll() {
        return userMapper.findAll();
    }

    public Optional<UserVo> findById(Long id) {
        return userMapper.findById(id);
    }

    public void saveUser(UserVo user) {
        userMapper.saveUser(user);
    }

    public void updateUser(UserVo user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    public Integer countUsername(String id, String username) {
        return userMapper.countUsername(id, username);
    }

    public Integer countEmail(String id, String email) {
        return userMapper.countEmail(id, email);
    }
}
