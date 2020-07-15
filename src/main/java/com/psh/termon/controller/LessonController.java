package com.psh.termon.controller;

import com.psh.termon.data.Answer;
import com.psh.termon.data.User;
import com.psh.termon.exception.BadRequestException;
import com.psh.termon.service.AnswerService;
import com.psh.termon.service.LessonService;
import com.psh.termon.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses/lessons")
public class LessonController {

    private final LessonService lessonService;
    private final UserService userService;
    private final AnswerService answerService;

    public LessonController(LessonService lessonService, UserService userService, AnswerService answerService) {
        this.lessonService = lessonService;
        this.userService = userService;
        this.answerService = answerService;
    }


    @GetMapping("/{lesson_id}")
    public String courseLesson(@AuthenticationPrincipal User user,
                               @PathVariable Long lesson_id,
                               Model model) {
        Answer answer = userService.findAnswerByUserAndLesson_Id(lesson_id, userService.findByLogin(user.getLogin()));
        model.addAttribute("lesson", lessonService.findById(lesson_id));
        model.addAttribute("user", user);
        model.addAttribute("ansExist", answer != null);
        if (answer != null) model.addAttribute("answer", answer.getAnswer());
        return "lesson";
    }

    @PostMapping("/{lesson_id}")
    public String courseLessonEditAnswer(
            @AuthenticationPrincipal User user,
            @PathVariable Long lesson_id,
            @RequestParam String type,
            @RequestParam(required = false) String ans
    ) {
        switch (type) {
            case "add": {
                Answer answer = new Answer(ans, lessonService.findById(lesson_id));
                answerService.addAnswer(answer);
                userService.addAnswer(answer, userService.findByLogin(user.getLogin()));
                break;
            }
            case "edit": {
                Answer answer = answerService.findByLesson_Id(lesson_id);
                answerService.editAnswer(ans, answer);
                //userService.editAnswer(ans, answer);
                break;
            }
            case "delete": {
                Answer answer = answerService.findByLesson_Id(lesson_id);
                userService.deleteAnswer(answer, userService.findByLogin(user.getLogin()));
                answerService.deleteAnswer(answer);
                break;
            }
            default: throw new BadRequestException();
        }
        return "redirect:/courses/lessons/" + lesson_id;
    }
}
