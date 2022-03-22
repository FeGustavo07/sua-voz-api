package com.suavoz.report.usecases.genre;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteGenre {

    private final GenrePersistenceGateway genrePersistenceGateway;

    public void execute(Genre genre) {
        genrePersistenceGateway.delete(genre);
    }
}
