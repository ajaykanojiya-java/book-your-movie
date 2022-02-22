package com.bookyourmovie.repository;

import com.bookyourmovie.domain.entities.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow,Long> {
    List<MovieShow> findMovieShowByMovie_Name(String name);
    List<MovieShow> findMovieShowByMovie_Id(Long id);
}
