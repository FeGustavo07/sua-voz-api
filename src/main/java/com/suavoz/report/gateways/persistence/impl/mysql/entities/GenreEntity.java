package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Genre;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class GenreEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public GenreEntity(Genre genre) {
        id = genre.getId();
        name = genre.getName();
    }

    public Genre toDomain() {
        return Genre.builder()
                .id(id)
                .name(name)
                .build();
    }
}
