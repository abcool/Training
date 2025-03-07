package edu.learning.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MoviesClientTest {
    MoviesClient client = new MoviesClient();

    @Test
    public void getMovieById(){
        Movie movie= client.getMovieById();
        Assertions.assertNotNull(movie);
        Assertions.assertEquals("Batman Beyond",movie.name());
    }

    @Test
    public void getMovieByIdAsync(){
        Movie movie= client.asyncGetMovieById().join();
        Assertions.assertNotNull(movie);
        Assertions.assertEquals("Batman Beyond",movie.name());
    }

    @Test
    public void getAllMovies(){
        List<Movie> movie= client.getAllMovies();
        Assertions.assertNotNull(movie);
        assert movie.stream().map(Movie::name).toList().contains("Batman Beyond");
    }

}
