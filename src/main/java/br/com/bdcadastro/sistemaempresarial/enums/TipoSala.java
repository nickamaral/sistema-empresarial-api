package br.com.bdcadastro.sistemaempresarial.enums;

public enum TipoSala {
    SAUDE("SAÚDE"),ESCRITORIO("ESCRITÓRIO");
    private String descricao;

    TipoSala(String descricao) {
        this.descricao = descricao;
    }
}
