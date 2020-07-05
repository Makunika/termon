package com.psh.termon.controller;

import com.psh.termon.data.Film;
import com.psh.termon.repos.FilmRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private FilmRep filmRep;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("user", "username");
        model.addAttribute("films", filmRep.findAll());
        return "main";
    }

    @GetMapping("/add")
    public String add() {
        return "addFilm";
    }

    @PostMapping(path = "/add")
    public String addGo(@RequestParam String nameFilm,
                        @RequestParam String urlPicter,
                        @RequestParam String year,
                        Model model) {
        filmRep.save(new Film(nameFilm, urlPicter, year));
        return "redirect:/";
    }
}
