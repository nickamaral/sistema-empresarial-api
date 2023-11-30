package br.com.bdcadastro.sistemaempresarial.services;

import br.com.bdcadastro.sistemaempresarial.dtos.SalaResponseDTO;
import br.com.bdcadastro.sistemaempresarial.entities.SalaEntity;
import br.com.bdcadastro.sistemaempresarial.repositories.ClienteRepository;
import br.com.bdcadastro.sistemaempresarial.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public List<SalaResponseDTO> listaTodos() {
        //return this.salaRepository.findAll().stream().map(salaEntity -> salaEntity.converteParaDTO());
        return this.salaRepository.findAll().stream().map(SalaEntity::converteParaDTO).collect(Collectors.toList());
    }
}
