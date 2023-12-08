package com.study.web1.service;

import com.study.web1.exception.BaseException;
import com.study.web1.vo.UserVo;
import com.study.web1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.study.web1.response.BaseResponseStatus.*;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> findAll() {
        return userMapper.findAll();
    }

    public UserVo findById(Long id) {
        return userMapper.findById(id)
                .orElseThrow(() -> new BaseException(NOT_FIND_USER));
    }

    public void saveUser(UserVo user) {
        checkDuplicateNickname(user);
        checkDuplicateEmail(user);

        int result = userMapper.saveUser(user);
        if (result < 1)
            throw new BaseException(INSERT_FAIL_USER);
    }

    public void updateUser(UserVo user) {
        checkDuplicateNickname(user);
        checkDuplicateEmail(user);

        int result = userMapper.updateUser(user);
        if (result < 1)
            throw new BaseException(MODIFY_FAIL_USER);
    }

    public void deleteUser(Long id) {
        int result = userMapper.deleteUser(id);
        if (result < 1)
            throw new BaseException(DELETE_FAIL_USER);
    }

    public Integer countUsername(Long id, String username) {
        return userMapper.countUsername(id, username);
    }

    public Integer countEmail(Long id, String email) {
        return userMapper.countEmail(id, email);
    }

    public void checkDuplicateNickname(UserVo user) {
        if (userMapper.countUsername(user.getId(), user.getUsername()) > 0)
            throw new BaseException(POST_USERS_EXISTS_USERNAME);
    }
    public void checkDuplicateEmail(UserVo user) {
        if (userMapper.countEmail(user.getId(), user.getEmail()) > 0)
            throw new BaseException(POST_USERS_EXISTS_EMAIL);
    }
}
