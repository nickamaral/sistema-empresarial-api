package br.com.bdcadastro.sistemaempresarial.entities;

public enum StatusDoLog {
    ENTRADA("ENTRADA"),SAIDA("SAÍDA");
    private String description;
    StatusDoLog (String description){
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
