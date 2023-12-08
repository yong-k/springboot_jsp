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

    Integer saveUser(UserVo user);

    Integer updateUser(UserVo user);

    Integer deleteUser(Long id);

    Integer countUsername(@Param("id") Long id, @Param("username") String username);

    Integer countEmail(@Param("id") Long id, @Param("email") String email);
}
