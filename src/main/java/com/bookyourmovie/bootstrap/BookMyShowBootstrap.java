package com.bookyourmovie.bootstrap;

import com.bookyourmovie.domain.entities.*;
import com.bookyourmovie.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class BookMyShowBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LoggerFactory.getLogger(BookMyShowBootstrap.class);

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("Inside onApplicationEvent() method");
        logger.info("Start bootstrapping the application {}", LocalDateTime.now());
        loadPlatformData();
        logger.info("End bootstrapping the application {}", LocalDateTime.now());
    }

    private void loadPlatformData(){
        Optional<Location> indore = locationRepository.findById(1L);
        Optional<Location> jabalpur = locationRepository.findById(2L);
        Optional<Location> bhopal = locationRepository.findById(3L);

        Optional<Movie> harryPotter1 = movieRepository.findById(1L);
        Optional<Movie> harryPotter2 = movieRepository.findById(2L);
        Optional<Movie> harryPotter3 = movieRepository.findById(3L);
        Optional<Movie> harryPotter4 = movieRepository.findById(4L);
        Optional<Movie> harryPotter5 = movieRepository.findById(5L);
        Optional<Movie> harryPotter6 = movieRepository.findById(6L);
        Optional<Movie> harryPotter7 = movieRepository.findById(7L);
        Optional<Movie> harryPotter8 = movieRepository.findById(8L);
        Optional<Movie> spiderMan = movieRepository.findById(9L);
        Optional<Movie> pushpaHindi = movieRepository.findById(10L);
        Optional<Movie> pushpaTelugu = movieRepository.findById(11L);

        Iterable<User> movieUsers = userRepository.findAll();

        //create theatre
        Theatre theatre1 = new Theatre("INOX",4,indore.get());
        Theatre theatre2 = new Theatre("INOX",2,jabalpur.get());
        Theatre theatre3= new Theatre("PVR",2,indore.get());
        Theatre theatre4 = new Theatre("PVR",3,bhopal.get());
        Theatre theatre5 = new Theatre("Movie Magic",1,indore.get());
        Theatre theatre6 = new Theatre("Movie Dhamal",1,jabalpur.get());

        //create screens indore
        Screen indoreInoxScreen1 = new Screen("SCREEN ONE", 50, theatre1);
        Screen indoreInoxScreen2 = new Screen("SCREEN TWO", 40, theatre1);
        Screen indoreInoxScreen3 = new Screen("SCREEN THREE", 30, theatre1);
        Screen indoreInoxScreen4 = new Screen("SCREEN FOUR", 50, theatre1);
        Screen indorePvrScreen1 = new Screen("SCREEN ONE", 50, theatre3);
        Screen indorePvrScreen2 = new Screen("SCREEN TWO", 40, theatre3);
        Screen indoreMMScreen1 = new Screen("SCREEN ONE", 40, theatre5);

        //create screens jabalpur
        Screen jbpInoxScreen1 = new Screen("SCREEN ONE", 50, theatre2);
        Screen jbpInoxScreen2 = new Screen("SCREEN TWO", 40, theatre2);
        Screen jbpMDScreen1 = new Screen("SCREEN ONE", 40, theatre6);

        //create screens bhopal
        Screen bplMovieDhamalscreen1 = new Screen("SCREEN ONE", 50, theatre4);
        Screen bplMovieDhamalscreen2 = new Screen("SCREEN ONE", 50, theatre4);

        //---------------------------Start creating show for indore -------------------------------------------------//
        //create show indore inox screen 1
        MovieShow hp1IndbInoxShow1 = new MovieShow("AFTERNOON1",LocalTime.of(12,0),LocalTime.of(15,0),
                50L,50L,0L,harryPotter1.get(),indoreInoxScreen1);
        MovieShow hp2IndbInoxShow2 = new MovieShow("AFTERNOON2",LocalTime.of(15,0),LocalTime.of(18,0),
                50L,50L,0L,harryPotter2.get(),indoreInoxScreen1);
        MovieShow hp3IndbInoxShow3 = new MovieShow("EVENING",LocalTime.of(18,0),LocalTime.of(21,0),
                50L,50L,0L,harryPotter3.get(),indoreInoxScreen1);
        MovieShow hp4IndbInoxShow4 = new MovieShow("NIGHT",LocalTime.of(21,0),LocalTime.of(00,0),
                50L,50L,0L,harryPotter4.get(),indoreInoxScreen1);

        //create show indore inox screen 2
        MovieShow hp5IndbInoxShow1 = new MovieShow("AFTERNOON1",LocalTime.of(12,0),LocalTime.of(15,0),
                40L,40L,0L,harryPotter5.get(),indoreInoxScreen2);
        MovieShow hp6IndbInoxShow2 = new MovieShow("AFTERNOON2",LocalTime.of(15,0),LocalTime.of(18,0),
                40L,40L,0L,harryPotter6.get(),indoreInoxScreen2);

        //create show indore inox screen 3
        MovieShow hp7IndbInoxShow1 = new MovieShow("AFTERNOON1",LocalTime.of(12,0),LocalTime.of(15,0),
                30L,30L,0L,harryPotter7.get(),indoreInoxScreen3);
        MovieShow hp8IndbInoxShow2 = new MovieShow("AFTERNOON2",LocalTime.of(15,0),LocalTime.of(18,0),
                30L,30L,0L,harryPotter8.get(),indoreInoxScreen3);

        //create show indore inox screen 4
        MovieShow smIndbInoxShow1 = new MovieShow("AFTERNOON1",LocalTime.of(12,0),LocalTime.of(15,0),
                30L,30L,0L,spiderMan.get(),indoreInoxScreen4);

        MovieShow pushpaIndbInoxShow2 = new MovieShow("EVENING",LocalTime.of(18,0),LocalTime.of(21,0),
                30L,30L,0L,pushpaHindi.get(),indoreInoxScreen4);


        MovieShow smPvrInoxShow1 = new MovieShow("AFTERNOON1",LocalTime.of(12,0),LocalTime.of(15,0),
                50L,50L,0L,spiderMan.get(),indorePvrScreen1);

        MovieShow pushpaIndbPvrShow1 = new MovieShow("EVENING",LocalTime.of(18,0),LocalTime.of(21,0),
                40L,40L,0L,pushpaHindi.get(),indorePvrScreen2);

        MovieShow pushpaIndbMMShow1 = new MovieShow("EVENING",LocalTime.of(18,0),LocalTime.of(21,0),
                50L,50L,0L,pushpaHindi.get(),indoreMMScreen1);

        //---------------------------END creating show for indore ---------------------------------------------------------------------//

        //---------------------------Start creating show for Jabalpur -------------------------------------------------//
        MovieShow spInoxJBPShow1 = new MovieShow("AFTERNOON1",LocalTime.of(12,0),LocalTime.of(15,0),
                50L,50L,0L,spiderMan.get(),jbpInoxScreen1);
        MovieShow pushpaInoxJBPShow1 = new MovieShow("AFTERNOON2",LocalTime.of(15,0),LocalTime.of(18,0),
                40L,40L,0L,pushpaHindi.get(),jbpInoxScreen2);
        MovieShow pushpaMDJBPShow1 = new MovieShow("NIGHT",LocalTime.of(21,0),LocalTime.of(00,0),
                40L,40L,0L,pushpaTelugu.get(),jbpMDScreen1);
        //---------------------------END creating show for Jabalpur ---------------------------------------------------------------------//


        //---------------------------Start creating show for Bhopal -------------------------------------------------//
        MovieShow hpMDBPLShow1 = new MovieShow("AFTERNOON1",LocalTime.of(12,0),LocalTime.of(15,0),
                50L,50L,0L,harryPotter1.get(),bplMovieDhamalscreen1);
        MovieShow hpMDBPLShow2 = new MovieShow("AFTERNOON1",LocalTime.of(12,0),LocalTime.of(15,0),
                50L,50L,0L,harryPotter1.get(),bplMovieDhamalscreen2);

        //---------------------------END creating show for Bhopal ---------------------------------------------------------------------//


        //creating bidirectional mapping
        //adding theatre to cities
        indore.get().addTheatre(theatre1).addTheatre(theatre3).addTheatre(theatre5);
        jabalpur.get().addTheatre(theatre2).addTheatre(theatre6);
        bhopal.get().addTheatre(theatre4);

        //adding screens to indore theatre
        theatre1.addScreen(indoreInoxScreen1).addScreen(indoreInoxScreen2).
                addScreen(indoreInoxScreen3).addScreen(indoreInoxScreen4);
        theatre3.addScreen(indorePvrScreen1).addScreen(indorePvrScreen2);
        theatre5.addScreen(indoreMMScreen1);

        //adding screens to jabalpur theatre
        theatre2.addScreen(jbpInoxScreen1).addScreen(jbpInoxScreen2);
        theatre6.addScreen(jbpMDScreen1);

        //adding screens to bhopal theatre
        theatre4.addScreen(bplMovieDhamalscreen1).addScreen(bplMovieDhamalscreen2);

        //adding shows in theatre for indore city
        indoreInoxScreen1.addMovieShow(hp1IndbInoxShow1).addMovieShow(hp2IndbInoxShow2).addMovieShow(hp3IndbInoxShow3).addMovieShow(hp4IndbInoxShow4);
        indoreInoxScreen2.addMovieShow(hp5IndbInoxShow1).addMovieShow(hp6IndbInoxShow2);
        indoreInoxScreen3.addMovieShow(hp7IndbInoxShow1).addMovieShow(hp8IndbInoxShow2);
        indoreInoxScreen4.addMovieShow(smIndbInoxShow1).addMovieShow(pushpaIndbInoxShow2);
        indorePvrScreen1.addMovieShow(smPvrInoxShow1);
        indorePvrScreen2.addMovieShow(pushpaIndbPvrShow1);
        indoreMMScreen1.addMovieShow(pushpaIndbMMShow1);

        //adding shows in theatre for jabalpur city
        jbpInoxScreen1.addMovieShow(spInoxJBPShow1);
        jbpInoxScreen2.addMovieShow(pushpaInoxJBPShow1);
        jbpMDScreen1.addMovieShow(pushpaMDJBPShow1);

        //adding shows in theatre for bhopal city
        bplMovieDhamalscreen1.addMovieShow(hpMDBPLShow1);
        bplMovieDhamalscreen2.addMovieShow(hpMDBPLShow2);

        //adding shows for movies
        harryPotter1.get().addShow(hp1IndbInoxShow1).addShow(hpMDBPLShow1);
        harryPotter2.get().addShow(hp2IndbInoxShow2).addShow(hpMDBPLShow2);
        harryPotter3.get().addShow(hp3IndbInoxShow3);
        harryPotter4.get().addShow(hp4IndbInoxShow4);
        harryPotter5.get().addShow(hp5IndbInoxShow1);
        harryPotter6.get().addShow(hp6IndbInoxShow2);
        harryPotter7.get().addShow(hp7IndbInoxShow1);
        harryPotter8.get().addShow(hp8IndbInoxShow2);
        spiderMan.get().addShow(smIndbInoxShow1).addShow(smPvrInoxShow1).addShow(spInoxJBPShow1);
        pushpaHindi.get().addShow(pushpaIndbInoxShow2).addShow(pushpaIndbPvrShow1).
                addShow(pushpaIndbMMShow1).addShow(pushpaInoxJBPShow1);
        pushpaTelugu.get().addShow(pushpaMDJBPShow1);


        //saving the entity
        List<Theatre> theatres= Arrays.asList(theatre1,theatre2,theatre3,theatre4,theatre5,theatre6);
        List<Screen> screens = Arrays.asList(indoreInoxScreen1,indoreInoxScreen2,indoreInoxScreen3,indoreInoxScreen4,jbpInoxScreen1,
                jbpInoxScreen2,jbpMDScreen1,bplMovieDhamalscreen1,bplMovieDhamalscreen2);
        List<MovieShow> movieShows = Arrays.asList(hp1IndbInoxShow1,hp2IndbInoxShow2,hp3IndbInoxShow3,hp4IndbInoxShow4,
                hp5IndbInoxShow1,hp6IndbInoxShow2,hp7IndbInoxShow1,hp8IndbInoxShow2, hpMDBPLShow1, hpMDBPLShow2,
                pushpaIndbInoxShow2,pushpaIndbMMShow1,pushpaIndbPvrShow1,pushpaInoxJBPShow1,pushpaMDJBPShow1,
                smIndbInoxShow1,smPvrInoxShow1,spInoxJBPShow1);

        theatreRepository.saveAll(theatres);
        screenRepository.saveAll(screens);
        movieShowRepository.saveAll(movieShows);

    }
}
