package com.anime.antako.dto.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginatedResponse<T> {

    private Integer page; // página actual
    private Integer size; // tamaño solicitado
    private Integer itemsOnPage; // items en esta página
    private Integer count; // total de registros
    private Integer totalPages; // total de páginas
    private T result; // result

}
