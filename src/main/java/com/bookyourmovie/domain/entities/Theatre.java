package com.bookyourmovie.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="THEATRE")
@Data
public class Theatre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATRE_ID")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(name = "THEATRE_NAME")
    private String theatreName;

    @Column(name = "NO_OF_SCREEN")
    private Integer noOfScreen;

    @ManyToOne
    @JoinColumn(name="LOC_ID")
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre")
    private List<Screen> screens = new ArrayList<>();

    public Theatre(String theatreName, Integer noOfScreen, Location location) {
        this.theatreName = theatreName;
        this.noOfScreen = noOfScreen;
        this.location = location;
    }

    //Bidirectional
    public Theatre addScreen(Screen screen){
        screen.setTheatre(this);
        screens.add(screen);
        return this;
    }
}
