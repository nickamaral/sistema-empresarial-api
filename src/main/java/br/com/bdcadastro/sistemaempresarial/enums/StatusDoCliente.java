package br.com.bdcadastro.sistemaempresarial.enums;

import br.com.bdcadastro.sistemaempresarial.entities.StatusDoLog;

public enum StatusDoCliente {

    PRESENTE(StatusDoLog.ENTRADA),
    AUSENTE(StatusDoLog.SAIDA);
    private StatusDoLog statusDoLog;
    StatusDoCliente(StatusDoLog statusDoLog){
        this.statusDoLog=statusDoLog;
    }

    public StatusDoLog getStatusDoLog() {
        return statusDoLog;
    }
}
