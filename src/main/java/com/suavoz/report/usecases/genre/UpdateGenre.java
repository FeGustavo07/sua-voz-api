package com.suavoz.report.usecases.genre;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateGenre {

    private final GenrePersistenceGateway genrePersistenceGateway;

    public Genre execute(Genre genre) {
        return genrePersistenceGateway.save(genre);
    }
}
