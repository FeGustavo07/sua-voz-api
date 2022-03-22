package com.suavoz.report.validators.genreValidator;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.domain.Genre;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DeleteGenreValidator {

    private final GenrePersistenceGateway genrePersistenceGateway;

    public List<String> validate(Genre genre) {
        List<String> validationErrors = new ArrayList<>();
        boolean existsGenre = genrePersistenceGateway.existsById(genre.getId());

        if (!existsGenre) {
            validationErrors.add("Genre doesn't exists");
        }

        if (genre.getId() == null) {
            validationErrors.add("Id is null");
        }

        return validationErrors;
    }

}
