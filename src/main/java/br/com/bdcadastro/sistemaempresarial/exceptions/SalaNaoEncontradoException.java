package br.com.bdcadastro.sistemaempresarial.exceptions;

public class SalaNaoEncontradoException extends RuntimeException{
    public SalaNaoEncontradoException() {super("Sala não encontrada");}
}
