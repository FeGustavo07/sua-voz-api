package com.suavoz.report.controllers;

import com.suavoz.report.controllers.requests.GenreRequest;
import com.suavoz.report.controllers.responses.GenreResponse;
import com.suavoz.report.domain.Genre;
import com.suavoz.report.usecases.genre.CreateGenre;
import com.suavoz.report.usecases.genre.DeleteGenre;
import com.suavoz.report.usecases.genre.ListGenres;
import com.suavoz.report.usecases.genre.UpdateGenre;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
public class GenreController {

    private final CreateGenre createGenre;
    private final DeleteGenre deleteGenre;
    private final UpdateGenre updateGenre;
    private final ListGenres listGenres;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreResponse createGenre(@RequestBody GenreRequest genreRequest) {
        Genre genre = genreRequest.toDomain();
        Genre savedGenre = createGenre.execute(genre);
        return new GenreResponse(savedGenre);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GenreResponse updateGenre(@PathVariable("id") Long id, @RequestBody GenreRequest genreRequest) {
        Genre genre = genreRequest.toDomain();
        genre.setId(id);
        Genre savedGenre = updateGenre.execute(genre);
        return new GenreResponse(savedGenre);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GenreResponse> listGenres() {
        List<Genre> genres = listGenres.execute();
        return genres.stream().map(GenreResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGenre(@PathVariable("id") Long id) {
        Genre genre = Genre.builder().build();
        genre.setId(id);
        deleteGenre.execute(genre);
    }

}
