package br.com.bdcadastro.sistemaempresarial.services;

import br.com.bdcadastro.sistemaempresarial.dtos.LogDoClienteInformacesResponseDTO;
import br.com.bdcadastro.sistemaempresarial.dtos.StatusDoClienteRequestDTO;
import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.LogDoClienteEntity;
import br.com.bdcadastro.sistemaempresarial.repositories.LogDoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogDoClienteService {
    @Autowired private LogDoClienteRepository logDoClienteRepository;

    private LogDoClienteEntity criaLogDoCliente(ClienteEntity cliente, StatusDoClienteRequestDTO statusDoLog) {
        return LogDoClienteEntity.builder()
                .statusDoLog(statusDoLog.getStatus().getStatusDoLog())
                .cpfDoCliente(cliente.getCpf())
                .nomeDoCliente(cliente.getNome())
                .dataHora(LocalDateTime.now())
                .sala(statusDoLog.getSala())
                .build();
    }

    public List<LogDoClienteEntity> findAll() {return logDoClienteRepository.findAllByOrderByIdDesc();}

    public LogDoClienteInformacesResponseDTO pegaUltimoLogDoCliente(ClienteEntity cliente) {
        List<LogDoClienteEntity> logDoClienteEntities = logDoClienteRepository.findAllByCpfDoClienteOrderByIdDesc(cliente.getCpf());
        if (logDoClienteEntities.isEmpty()) {
            return LogDoClienteInformacesResponseDTO.criaDTOVazio();
        }else {
            LogDoClienteInformacesResponseDTO dto = logDoClienteEntities.get(0).convertToInfosDTO();
            return dto;
        }

    }

    public void marcaLogDoCliente(ClienteEntity cliente, StatusDoClienteRequestDTO statusDTO) {
        LogDoClienteEntity logDoCliente = criaLogDoCliente(cliente, statusDTO);
        logDoClienteRepository.save(logDoCliente);
    }
}
