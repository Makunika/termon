package com.psh.termon.service.impl;

import com.psh.termon.data.User;
import com.psh.termon.repos.UserRep;
import com.psh.termon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRep userRep;

    @Override
    public User addUser(User user) {
        return userRep.saveAndFlush(user);
    }

    @Override
    public void delete(long id) {
        userRep.deleteById(id);
    }

    @Override
    public User getByName(String name) {
        return userRep.findByLogin(name);
    }

    @Override
    public User editBank(User user) {
        return userRep.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRep.findAll();
    }
}
