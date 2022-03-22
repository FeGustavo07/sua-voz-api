package com.suavoz.report.gateways.persistence;

import com.suavoz.report.domain.Genre;


import java.util.List;

public interface GenrePersistenceGateway {

    Genre save(Genre genre);

    void delete(Genre genre);

    List<Genre> findAll();

    boolean existsById(Long id);
}
