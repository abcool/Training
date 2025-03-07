package edu.learning.http;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record Movie(
        Double movie_id,
        String name,
        Integer year,
        String cast,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate release_date
) { }
