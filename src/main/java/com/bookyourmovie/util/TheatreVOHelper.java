package com.bookyourmovie.util;

import com.bookyourmovie.domain.entities.Theatre;
import com.bookyourmovie.domain.valueobject.MovieShowVO;
import com.bookyourmovie.domain.valueobject.ScreenVO;
import com.bookyourmovie.domain.valueobject.TheatreListVO;
import com.bookyourmovie.domain.valueobject.TheatreVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TheatreVOHelper {

    public TheatreListVO constructTheatreVO(List<Theatre> theatreList){

        TheatreListVO theatreListVO = new TheatreListVO();

        List<TheatreVO> theatreVOList = theatreList.stream().map(theatre -> {
            TheatreVO theatreVO = new TheatreVO();
            theatreVO.setTheatreName(theatre.getTheatreName());
            theatreVO.setNoOfScreen(theatre.getNoOfScreen());
            theatreVO.setCity(theatre.getLocation().getCity());

            List<ScreenVO> screenVOList = theatre.getScreens().stream().map(screen -> {
                ScreenVO screenVO = new ScreenVO();
                screenVO.setScreenName(screen.getScreenName());
                screenVO.setNoOfSeats(screen.getNoOfSeat());

                List<MovieShowVO> movieShowVOList = screen.getMovieShow().stream().map(movieShow -> {
                    MovieShowVO movieShowVO = new MovieShowVO();
                    movieShowVO.setShowName(movieShow.getShowName());
                    movieShowVO.setStartTime(movieShow.getStartTime());
                    movieShowVO.setEndTime(movieShow.getEndTime());
                    movieShowVO.setAvailableSeat(movieShow.getAvailableSeat());
                    movieShowVO.setTotalSeat(movieShow.getTotalSeat());
                    movieShowVO.setScreenName(movieShow.getScreen().getScreenName());

                    return movieShowVO;
                }).collect(Collectors.toList());
                screenVO.setMovieShowVOList(movieShowVOList);

                return screenVO;
            }).collect(Collectors.toList());

            theatreVO.setScreenVOList(screenVOList);
            return theatreVO;
        }).collect(Collectors.toList());

        theatreListVO.setTheatreVOList(theatreVOList);

        return theatreListVO;
    }
}
