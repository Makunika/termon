package com.psh.termon.service;

import com.psh.termon.repos.FilmRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Autowired
    private FilmRep filmRep;
}
