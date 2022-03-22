package com.suavoz.report.usecases.genre;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.exceptions.ValidationExecption;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import com.suavoz.report.validators.genreValidator.CreateAndUpdateGenreValidator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateGenre {

    private final GenrePersistenceGateway genrePersistenceGateway;
    private final CreateAndUpdateGenreValidator createAndUpdateGenreValidator;

    public Genre execute(Genre genre) {
        val validationErrors = createAndUpdateGenreValidator.validate(genre);

        if (!validationErrors.isEmpty()) {
            throw new ValidationExecption(validationErrors);
        }

        return genrePersistenceGateway.save(genre);
    }
}
