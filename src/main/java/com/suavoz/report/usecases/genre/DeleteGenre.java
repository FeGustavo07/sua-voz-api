package com.suavoz.report.usecases.genre;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import com.suavoz.report.validators.genreValidator.DeleteGenreValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteGenre {

    private final GenrePersistenceGateway genrePersistenceGateway;
    private final DeleteGenreValidator deleteGenreValidator;

    public void execute(Genre genre) {
        val validationErrors = deleteGenreValidator.validate(genre);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        genrePersistenceGateway.delete(genre);
    }
}
