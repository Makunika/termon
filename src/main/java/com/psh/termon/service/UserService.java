package com.psh.termon.service;

import com.psh.termon.data.User;
import com.psh.termon.repos.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRep userRep;

    public User addUser(User user) {
        return userRep.save(user);
    }


    public void delete(long id) {
        userRep.deleteById(id);
    }


    public User getByName(String name) {
        return userRep.findByLogin(name).get(0);
    }


    public User editBank(User user) {
        return userRep.save(user);
    }


    public Iterable<User> getAll() {
        return userRep.findAll();
    }

}
