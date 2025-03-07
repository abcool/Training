package edu.learning.http;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
public class MoviesClient {
    public HttpClient client = HttpClient
            .newBuilder()
            .connectTimeout(Duration.ofMinutes(2))
            .build();
    public static String ALL_MOVIES = "http://127.0.0.1:8000/src/main/resources/movies.json";
    public static String MOVIE_BY_ID ="http://127.0.0.1:8000/src/main/resources/movie_by_id.json";
    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public Movie getMovieById(){
        HttpRequest request = generateRequest(MOVIE_BY_ID);
        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), Movie.class);
        } catch (Exception e) {
            System.err.println(" Error while making request");
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Movie> asyncGetMovieById(){
        HttpRequest request = generateRequest(MOVIE_BY_ID);
        try {
            CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
            return response.thenApply(httpResponse -> {
                try {
                    return mapper.readValue(httpResponse.body(),Movie.class);
                } catch (JsonProcessingException e) {
                    System.err.println(" Unable to parse json response to: "+ Movie.class);
                    throw new RuntimeException(e);
                }
            });

        } catch (Exception e) {
            System.err.println(" Error while making request");
            throw new RuntimeException(e);
        }
    }
    public List<Movie> getAllMovies(){
        HttpRequest request = generateRequest(ALL_MOVIES);
        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), new TypeReference<List<Movie>>() {});
        } catch (Exception e) {
            System.err.println(" Error while making request");
            throw new RuntimeException(e);
        }
    }

    private HttpRequest generateRequest(String url){
        return HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
    }
}
