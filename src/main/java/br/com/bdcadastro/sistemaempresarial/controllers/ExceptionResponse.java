package br.com.bdcadastro.sistemaempresarial.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private String status;
    private String message;
}
