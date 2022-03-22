package com.suavoz.report.usecases.genre;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListGenres {

    private final GenrePersistenceGateway genrePersistenceGateway;

    public List<Genre> execute() {
        return genrePersistenceGateway.findAll();
    }
}
