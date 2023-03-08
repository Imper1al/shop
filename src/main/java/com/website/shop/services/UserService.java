package com.website.shop.services;

import com.website.shop.dao.UserDAO;
import com.website.shop.entity.User;
import com.website.shop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserDAO userDAO;

    public User createUser(User user) {
        User createdUser = null;
        if (userValidator.validateUserData(user)) {
            createdUser = userDAO.createUser(user);
        }
        return createdUser;
    }

    public User updateUser(long userId, User user) {
        User updatedUser = null;
        if (userId > 0 && userValidator.validateUserData(user)) {
            updatedUser = userDAO.updateUser(userId, user);
        }
        return updatedUser;
    }

    public void deleteUsers(List<Integer> userIds) {
        userDAO.deleteUsers(userIds);
    }

    public User getUser(long userId) {
        return userDAO.getUser(userId);
    }
}
