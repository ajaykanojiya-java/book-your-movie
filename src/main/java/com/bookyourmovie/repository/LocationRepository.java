package com.bookyourmovie.repository;

import com.bookyourmovie.domain.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findLocationByCity(String city);
}
