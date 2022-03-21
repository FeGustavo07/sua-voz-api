package com.suavoz.report.gateways.persistence.impl.mysql.entities;

import com.suavoz.report.domain.Genre;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@NoArgsConstructor
public class GenreEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<ReportEntity> reportEntities = new ArrayList<>();

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
