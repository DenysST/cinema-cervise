package cinema.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.dto.request.MovieSessionRequestDto;
import cinema.dto.response.MovieSessionResponseDto;
import cinema.model.MovieSession;
import cinema.util.DateTimePatternUtil;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper implements RequestDtoMapper<MovieSessionRequestDto, MovieSession>,
        ResponseDtoMapper<MovieSessionResponseDto, MovieSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    public MovieSessionMapper(CinemaHallService cinemaHallService, MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @Override
    public MovieSession mapToModel(MovieSessionRequestDto dto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(dto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
        movieSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return movieSession;
    }

    @Override
    public MovieSessionResponseDto mapToDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setMovieSessionId(movieSession.getId());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseDto.setMovieId(movieSession.getMovie().getId());
        responseDto.setMovieTitle(movieSession.getMovie().getTitle());
        responseDto.setShowTime(movieSession.getShowTime().format(formatter));
        return responseDto;
    }
}
