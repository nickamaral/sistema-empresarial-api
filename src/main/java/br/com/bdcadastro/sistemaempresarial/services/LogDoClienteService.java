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

    public void marcaLogDoCliente(ClienteEntity cliente, StatusDoLog statusDoLog){
        LogDoClienteEntity logDoCliente = criaLogDoCliente(cliente, statusDoLog);
        logDoClienteRepository.save(logDoCliente);
    }
    private LogDoClienteEntity criaLogDoCliente(ClienteEntity cliente, StatusDoLog statusDoLog) {
        return LogDoClienteEntity.builder()
                .statusDoLog(statusDoLog)
                .cpfDoCliente(cliente.getCpf())
                .nomeDoCliente(cliente.getNome())
                .dataHora(LocalDateTime.now())
                .sala("10")
                .build();
    }

    public List<LogDoClienteEntity> findAll() {return logDoClienteRepository.findAllByOrderByIdDesc();}

}
