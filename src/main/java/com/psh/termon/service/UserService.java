package com.psh.termon.service;

import com.psh.termon.data.*;
import com.psh.termon.exception.NotFoundException;
import com.psh.termon.repos.UserRep;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRep userRep;

    public UserService(UserRep userRep) {
        this.userRep = userRep;
    }

    public User addUser(User user) {
        user.setRoles(Collections.singleton(Role.USER));
        return userRep.save(user);
    }

    public void delete(long id) {
        userRep.deleteById(id);
    }


    public User editUser(User user, String username, Set<String> newRoles) {
        user.setLogin(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : newRoles) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        if (user.getRoles().isEmpty()) user.getRoles().add(Role.USER);

        return userRep.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRep.findByLogin(s);
    }

    public User findById(Long userId) throws NotFoundException {
        return userRep.findById(userId).orElseThrow(NotFoundException::new);
    }

    public Iterable<User> findAll() {
        return userRep.findAll();
    }

    public User subCourse(User user, Course course) {
        if (user.getCourses().stream().noneMatch(course1 -> course1.getId().equals(course.getId())))
            user.getCourses().add(course);
        return userRep.save(user);
    }

    public User unSubCourse(User user, Course course) {
        user.getCourses().remove(
                user.getCourses()
                        .stream()
                        .filter(course1 -> course1.getId().equals(course.getId()))
                        .findFirst()
                        .orElse(null)
        );
        return userRep.save(user);
    }

    public User findByLogin(String login) {
        return userRep.findByLogin(login);
    }

    public User addAnswer(Answer answer, User user) {
        user.getAnswers().add(answer);
        return userRep.save(user);
    }

    public User deleteAnswer(Answer answer, User user) {
        user.getAnswers().remove(
                user.getAnswers().stream()
                        .filter(answer1 -> answer1.getId().equals(answer.getId()))
                        .findFirst()
                        .orElse(null)
        );
        return userRep.save(user);
    }

    public User editAnswer(Answer answer, User user) {
        user.getAnswers().remove(
                user.getAnswers().stream()
                        .filter(answer1 -> answer1.getId().equals(answer.getId()))
                        .findFirst()
                        .orElse(null)
        );
        user.getAnswers().add(answer);
        return userRep.save(user);
    }

    public Answer findAnswerByUserAndLesson_Id(Long lesson_id, User user) {
        return user.getAnswers().stream()
                .filter(answer -> answer.getLesson().getId().equals(lesson_id))
                .findFirst()
                .orElse(null);
    }
}
