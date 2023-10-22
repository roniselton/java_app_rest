package com.example.apprestbasic.excecoes;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {

    private LocalDateTime timestamp = LocalDateTime.now();
    private String status = "error";
    private int statusCode = 400;
    private String error;


}
