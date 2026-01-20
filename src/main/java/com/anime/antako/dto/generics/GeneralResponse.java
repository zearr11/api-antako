package com.anime.antako.dto.generics;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralResponse<T> {

    private String status;
    private T data;
    private String message;

}
