package br.com.bdcadastro.sistemaempresarial.enums;

import lombok.Getter;

import java.security.PrivilegedAction;
import java.util.stream.Stream;
@Getter
public enum TipoSala {
    SAUDE("SAÚDE","saude"),ESCRITORIO("ESCRITÓRIO","escritorio");
    private String descricao;
    private String codigo;

    TipoSala(String descricao,String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public static TipoSala pegaTipoSala(String tipoSala) {
        return Stream.of(TipoSala.values()).filter(t -> t.codigo.equalsIgnoreCase(tipoSala)).findFirst()
                .orElseThrow(()->new RuntimeException("tipo sala não encontrado"));
    }
}
