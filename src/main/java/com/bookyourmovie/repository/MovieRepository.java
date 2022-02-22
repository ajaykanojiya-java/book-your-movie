package com.bookyourmovie.repository;

import com.bookyourmovie.domain.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByName(String name);
    Optional<Movie> findFirstByNameContaining(String name);
    List<Movie> findMovieByNameContaining(String name);
    List<Movie> findMovieByGenreContaining(String genre);
}
