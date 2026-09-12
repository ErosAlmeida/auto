package com.br.auto.Car.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    @NotBlank
    private String placa;

    @NotBlank(message = "teste")
    private String modelo;

    @NotNull
    @Positive
    private Integer ano;
}