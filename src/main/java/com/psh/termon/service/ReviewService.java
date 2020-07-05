package com.psh.termon.service;

import com.psh.termon.repos.ReviewRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRep reviewRep;


}
