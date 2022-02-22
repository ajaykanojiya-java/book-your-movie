package com.bookyourmovie.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="LOCATION")
@Data
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LOC_ID")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Theatre> theatres = new ArrayList<>();

    public Location addTheatre(Theatre theatre){
        theatre.setLocation(this);
        theatres.add(theatre);
        return this;
    }
}
