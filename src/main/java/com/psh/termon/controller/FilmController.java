package com.psh.termon.controller;

import com.psh.termon.data.Film;
import com.psh.termon.data.Review;
import com.psh.termon.repos.FilmRep;
import com.psh.termon.repos.ReviewRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmRep filmRep;

    @Autowired
    private ReviewRep reviewRep;

    @GetMapping("/{id}")
    public String film(@PathVariable String id, Model model) {
        Long idFilm = 0L;
        try {
            idFilm = Long.parseLong(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "parse long error"
            );
        }

        Film film = filmRep.findById(idFilm).orElse(new Film("404", "404", "404"));
        model.addAttribute("film", film);
        model.addAttribute("reviews", reviewRep.findByIdFilm(idFilm));
        return "film";
    }
    @PostMapping("/{id}")
    public String addReview(@PathVariable String id,
                            @RequestParam String username,
                            @RequestParam String name,
                            @RequestParam String text) {
        Long idFilm = 0L;
        try {
            idFilm = Long.parseLong(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "parse long error"
            );
        }

        reviewRep.save(new Review(username, name, text, idFilm));

        return "redirect:/film/" + id;
    }
}
