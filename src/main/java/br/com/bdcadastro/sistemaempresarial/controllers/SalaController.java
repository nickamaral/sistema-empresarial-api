package br.com.bdcadastro.sistemaempresarial.controllers;

import br.com.bdcadastro.sistemaempresarial.dtos.ClienteRequestDTO;
import br.com.bdcadastro.sistemaempresarial.dtos.SalaRequestDTO;
import br.com.bdcadastro.sistemaempresarial.dtos.SalaResponseDTO;
import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.SalaEntity;
import br.com.bdcadastro.sistemaempresarial.services.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/salas")
public class SalaController {
    @Autowired
    private SalaService salaService;
    @GetMapping
    public List<SalaResponseDTO> listaTodos(){
        return salaService.listaTodos();
    }

    @PostMapping
    public SalaResponseDTO criaSala(@RequestBody @Valid SalaRequestDTO salaRequestDTO) {
        return salaService.criaSala(salaRequestDTO);
    }
    @GetMapping("/{id}")
    public SalaResponseDTO buscaPorId(@PathVariable Long id){ //PathVariable ele relaciona a variavel com o conteúdo da url, nesse caso o /{id} que foi mapeado
        return salaService.buscaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletaSala(@PathVariable Long id){
        salaService.deleteById(id);
    }
}
