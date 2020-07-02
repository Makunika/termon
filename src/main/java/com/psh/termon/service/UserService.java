package com.psh.termon.service;

import com.psh.termon.data.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User addUser(User user);
    void delete(long id);
    User getByName(String name);
    User editBank(User bank);
    List<User> getAll();
}
