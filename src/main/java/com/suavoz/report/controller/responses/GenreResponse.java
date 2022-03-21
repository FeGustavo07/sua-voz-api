package com.suavoz.report.controller.responses;

import com.suavoz.report.domain.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class GenreResponse {
    private Long id;
    private String name;

    public GenreResponse(Genre genre) {
        id = genre.getId();
        name = genre.getName();
    }
}
