package com.study.web1.service;

import com.study.web1.mapper.UserMapper;
import com.study.web1.vo.UserVo;
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

    public void saveUser(UserVo user) {
        userMapper.saveUser(user);
    }

    public UserVo findById(Long id) {
        return userMapper.findById(id);
    }

    public void updateUser(UserVo user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }
}
