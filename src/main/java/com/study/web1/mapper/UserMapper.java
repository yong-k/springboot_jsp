package com.study.web1.mapper;

import com.study.web1.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    List<UserVo> findAll();

    Optional<UserVo> findById(Long id);

    Optional<UserVo> findByUsername(String username);

    Integer registerUser(UserVo user);

    Integer updateUser(UserVo user);

    Integer deleteUser(Long id);

    Integer countDuplicateUsername(@Param("id") Long id, @Param("username") String username);

    Integer countDuplicateEmail(@Param("id") Long id, @Param("email") String email);
}
