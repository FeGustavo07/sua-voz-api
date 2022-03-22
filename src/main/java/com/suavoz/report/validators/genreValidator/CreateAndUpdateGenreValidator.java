package com.suavoz.report.validators.genreValidator;

import com.suavoz.report.domain.AgeGroup;
import com.suavoz.report.domain.Genre;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateAndUpdateGenreValidator {

    public List<String> validate(Genre genre) {
        List<String> validationErrors = new ArrayList<>();

        if (genre == null) {
            validationErrors.add("Genre is null");
        }

        if (!StringUtils.hasText(genre.getName())) {
            validationErrors.add("Genre Name is empty");
        }

        return validationErrors;
    }
}
