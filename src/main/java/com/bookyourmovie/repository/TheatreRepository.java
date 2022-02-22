package com.bookyourmovie.repository;

import com.bookyourmovie.domain.entities.Location;
import com.bookyourmovie.domain.entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {
    List<Theatre> findAllByLocation(Location location);
    List<Theatre> findAllByLocationCityContaining(String name);

}
