package com.suavoz.report.usecases.genre;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.domain.Report;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.List;

@MockitoSettings
class ListGenresTest {

    @InjectMocks
    ListGenres listGenres;

    @Mock
    GenrePersistenceGateway genrePersistenceGateway;

    @Test
    void ShouldReturnAListWhenFindReports() {
        Genre genre = Genre.builder().build();

        List<Genre> genres = new ArrayList<>();

        genres.add(genre);
        genres.add(genre);

        Mockito.when(genrePersistenceGateway.findAll()).thenReturn(List.of(genre, genre));

        List<Genre> genreList = genrePersistenceGateway.findAll();

        Assertions.assertEquals(genres, genreList);
        Mockito.verify(genrePersistenceGateway, Mockito.times(1)).findAll();
    }

    @Test
    void ShouldReturnAnEmptyListWhenDontFindGenres() {
        List<Genre> genres = new ArrayList<>();

        List<Genre> genreList = listGenres.execute();

        Assertions.assertEquals(genres, genreList);
        Mockito.verify(genrePersistenceGateway, Mockito.times(1)).findAll();
    }

}