package com.ra.session03.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDTO<T> {
    private int httpStatus;
    private  String message;
    private T data;
}
