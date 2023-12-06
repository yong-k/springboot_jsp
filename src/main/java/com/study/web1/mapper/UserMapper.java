package com.study.web1.mapper;

import com.study.web1.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVo> findAll();

    void saveUser(UserVo user);

    UserVo findById(Long id);

    void updateUser(UserVo user);

    void deleteUser(Long id);
}
