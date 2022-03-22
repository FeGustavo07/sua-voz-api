package com.suavoz.report.usecases.genre;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import com.suavoz.report.validators.genreValidator.CreateAndUpdateGenreValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class CreateGenreTest {

    @InjectMocks
    CreateGenre createGenre;

    @Mock
    GenrePersistenceGateway genrePersistenceGateway;

    @Mock
    CreateAndUpdateGenreValidator createAndUpdateGenreValidator;

    @Test
    void ShouldCreateWhenValidationSucced() {
        Genre genre = Genre.builder().build();
        Mockito.when(createAndUpdateGenreValidator.validate(genre)).thenReturn(List.of());
        createGenre.execute(genre);
        Mockito.verify(genrePersistenceGateway).save(genre);
    }

    @Test
    void ShouldNotCreateWhenValidationFailed() {
        Genre genre = Genre.builder().build();
        Mockito.when(createAndUpdateGenreValidator.validate(genre)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> createGenre.execute(genre));
    }

}