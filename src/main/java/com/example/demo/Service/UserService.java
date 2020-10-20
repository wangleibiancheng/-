package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanglei
 * @date 2020/10/20 11:22 上午
 * @File : UserService.java
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User findById(int id) {
        return userDao.findById(id);
    }
}
