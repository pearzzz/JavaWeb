package com.pearz.book.service.impl;

import com.pearz.book.dao.UserDao;
import com.pearz.book.dao.impl.UserDaoImpl;
import com.pearz.book.pojo.User;
import com.pearz.book.service.UserService;

/**
 * @author pearz
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    public void registUser(User user) {
        userDao.saveUser(user);
    }

    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
           // 等于null,说明没查到，没查到表示可用
           return false;
        }

        return true;

    }
}
