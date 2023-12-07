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

    void saveUser(UserVo user);

    void updateUser(UserVo user);

    void deleteUser(Long id);
    Integer countUsername(@Param("id") String id, @Param("username") String username);
    Integer countEmail(@Param("id") String id, @Param("email") String email);
}
