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
class UpdateGenreTest {

    @InjectMocks
    UpdateGenre updateGenre;

    @Mock
    GenrePersistenceGateway genrePersistenceGateway;

    @Mock
    CreateAndUpdateGenreValidator createAndUpdateGenreValidator;

    @Test
    void ShouldUpdateWhenValidationSucced() {
        Genre genre = Genre.builder().build();
        Mockito.when(createAndUpdateGenreValidator.validate(genre)).thenReturn(List.of());
        updateGenre.execute(genre);
        Assertions.assertDoesNotThrow(() -> ValidationExecption.class);
        Mockito.verify(genrePersistenceGateway, Mockito.times(1)).save(genre);
    }

    @Test
    void ShouldNotUpdateWhenValidationFailed() {
        Genre genre = Genre.builder().build();
        Mockito.when(createAndUpdateGenreValidator.validate(genre)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> updateGenre.execute(genre));
    }

}