package com.psh.termon.repos;


import com.psh.termon.data.Review;
import com.psh.termon.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRep extends CrudRepository<Review, Long> {
    List<Review> findByUsername(String username);
    List<Review> findByIdFilm(Long idFilm);
}
