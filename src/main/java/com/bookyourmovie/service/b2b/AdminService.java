package com.bookyourmovie.service.b2b;

import com.bookyourmovie.domain.entities.*;

public interface AdminService {
    public Location addLocation();
    public Theatre addTheatre();
    public Screen addScreen();
    public Movie addMovie();
    public MovieShow addMovieShow();
}
