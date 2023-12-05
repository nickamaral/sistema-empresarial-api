package br.com.bdcadastro.sistemaempresarial.services;

import br.com.bdcadastro.sistemaempresarial.dtos.SalaRequestDTO;
import br.com.bdcadastro.sistemaempresarial.dtos.SalaResponseDTO;
import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.SalaEntity;
import br.com.bdcadastro.sistemaempresarial.exceptions.ClienteNaoEncontradoException;
import br.com.bdcadastro.sistemaempresarial.exceptions.SalaNaoEncontradoException;
import br.com.bdcadastro.sistemaempresarial.repositories.ClienteRepository;
import br.com.bdcadastro.sistemaempresarial.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public SalaResponseDTO buscaPorId(Long id) {
        return buscaPorIdOuJogaException(id).converteParaDTO();
    }
    private SalaEntity buscaPorIdOuJogaException(Long id){
        return salaRepository.findById(id).orElseThrow(SalaNaoEncontradoException::new);
    }

    public List<SalaResponseDTO> listaTodos() {
        //return this.salaRepository.findAll().stream().map(salaEntity -> salaEntity.converteParaDTO());
        return this.salaRepository.findAll().stream().map(SalaEntity::converteParaDTO).collect(Collectors.toList());
    }

    public SalaResponseDTO criaSala(SalaRequestDTO salaRequestDTO) {
         salaRepository.save(salaRequestDTO.converterNaEntidade());
         return null;
    }
    @Transactional // grande mudança no banco de dados
    public void deleteById(Long id) {
        SalaEntity sala = buscaPorIdOuJogaException(id);
        salaRepository.deleteById(id);
    }
}
