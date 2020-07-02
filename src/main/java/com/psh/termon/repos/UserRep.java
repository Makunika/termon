package com.psh.termon.repos;


import com.psh.termon.data.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRep extends JpaRepository<User, Long> {
    User findByLogin(String name);
}
