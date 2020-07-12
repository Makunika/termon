package com.psh.termon.service;

import com.psh.termon.data.User;
import com.psh.termon.repos.UserRep;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRep userRep;

    public UserService(UserRep userRep) {
        this.userRep = userRep;
    }

    public User addUser(User user) {
        return userRep.save(user);
    }


    public void delete(long id) {
        userRep.deleteById(id);
    }


    public User getByName(String name) {
        return userRep.findByLogin(name);
    }


    public User editUser(User user) {
        return userRep.save(user);
    }


    public Iterable<User> getAll() {
        return userRep.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRep.findByLogin(s);
        return user;
    }
}
