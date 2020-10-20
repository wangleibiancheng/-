package com.example.demo.Dao;

import com.example.demo.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author wanglei
 * @date 2020/10/20 12:28 下午
 * @File : UserDao.java
 */

@Mapper
public interface UserDao {
    @Select("select * from user where id=#{id}")
    User findById(@Param("id") int id);
}
