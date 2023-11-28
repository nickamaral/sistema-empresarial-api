package br.com.bdcadastro.sistemaempresarial.exceptions;

import lombok.experimental.SuperBuilder;

public class ClienteNaoEncontradoException extends RuntimeException{
    public ClienteNaoEncontradoException(){
        super("Cliente não encontrado.");
    }
}
