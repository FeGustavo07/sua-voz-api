package com.suavoz.report.gateways.persistence.impl.mysql;

import com.suavoz.report.domain.Genre;
import com.suavoz.report.gateways.persistence.GenrePersistenceGateway;
import com.suavoz.report.gateways.persistence.impl.mysql.entities.GenreEntity;
import com.suavoz.report.gateways.persistence.impl.mysql.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GenrePersistenceImpl implements GenrePersistenceGateway {

    private final GenreRepository genreRepository;

    @Override
    public Genre save(Genre genre) {
        GenreEntity genreEntity = new GenreEntity(genre);
        GenreEntity entity = genreRepository.save(genreEntity);
        return entity.toDomain(false);
    }

    @Override
    public void delete(Genre genre) {
        genreRepository.deleteById(genre.getId());
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll().stream().map(genre -> genre.toDomain(false)).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
