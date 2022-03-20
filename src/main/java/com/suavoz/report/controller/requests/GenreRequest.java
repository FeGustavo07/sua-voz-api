package com.suavoz.report.controller.requests;

import com.suavoz.report.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GenreRequest {
    private Long id;
    private String name;

    public Genre toDomain() {
        return Genre.builder()
                .id(id)
                .name(name)
                .build();
    }
}
