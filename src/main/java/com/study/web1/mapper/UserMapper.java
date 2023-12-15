package com.study.web1.mapper;

import com.study.web1.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVo> findAll();

    UserVo findById(Long id);

    int registerUser(UserVo user);

    int updateUser(UserVo user);

    int deleteUser(Long id);

    int countDuplicateUsername(@Param("id") Long id, @Param("username") String username);

    int countDuplicateEmail(@Param("id") Long id, @Param("email") String email);
}
