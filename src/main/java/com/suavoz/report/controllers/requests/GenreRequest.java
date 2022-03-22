package com.suavoz.report.controllers.requests;

import com.suavoz.report.domain.Genre;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GenreRequest {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(required = true, value = "Genre name", example = "Masculino")
    private String name;

    public Genre toDomain() {
        return Genre.builder()
                .id(id)
                .name(name)
                .build();
    }
}
