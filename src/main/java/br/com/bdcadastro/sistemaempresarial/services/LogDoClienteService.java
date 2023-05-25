package br.com.bdcadastro.sistemaempresarial.services;

import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.LogDoClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.StatusDoLog;
import br.com.bdcadastro.sistemaempresarial.repositories.LogDoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogDoClienteService {
    @Autowired private LogDoClienteRepository logDoClienteRepository;
    public void marcaEntradaDoCliente(ClienteEntity cliente){
        LogDoClienteEntity logDoCliente = criaLogDoCliente(cliente);
        logDoClienteRepository.save(logDoCliente);
    }
    private LogDoClienteEntity criaLogDoCliente(ClienteEntity cliente) {
        return LogDoClienteEntity.builder()
                .statusDoLog(StatusDoLog.ENTRADA)
                .cliente(cliente).dataHora(LocalDateTime.now())
                .sala("10")
                .build();
    }

    public List<LogDoClienteEntity> findAll() {return logDoClienteRepository.findAll();}
}
