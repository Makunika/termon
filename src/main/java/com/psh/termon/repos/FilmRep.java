package com.psh.termon.repos;

import com.psh.termon.data.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRep extends CrudRepository<Film, Long> {

}
