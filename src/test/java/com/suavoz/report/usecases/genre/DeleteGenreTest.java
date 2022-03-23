package com.suavoz.report.usecases.genre;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import com.suavoz.report.validators.genreValidator.DeleteGenreValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

@MockitoSettings
class DeleteGenreTest {

    @InjectMocks
    DeleteGenre deleteGenre;

    @Mock
    DeleteGenreValidator deleteGenreValidator;

    @Mock
    GenrePersistenceGateway genrePersistenceGateway;

    @Test
    void ShouldDeleteWhenValidationSucceed() {
        Genre genre = Genre.builder().build();
        Mockito.when(deleteGenreValidator.validate(genre)).thenReturn(List.of());
        deleteGenre.execute(genre);
        Mockito.verify(genrePersistenceGateway).delete(genre);
    }

    @Test
    void ShouldNotDeleteWhenValidationFailed() {
        Genre genre = Genre.builder().build();
        Mockito.when(deleteGenreValidator.validate(genre)).thenReturn(List.of("Errors"));
        Assertions.assertThrows(ValidationExecption.class, () -> deleteGenre.execute(genre));
    }

}