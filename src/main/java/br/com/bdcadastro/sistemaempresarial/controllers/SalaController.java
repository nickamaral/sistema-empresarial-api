package br.com.bdcadastro.sistemaempresarial.controllers;

import br.com.bdcadastro.sistemaempresarial.dtos.SalaResponseDTO;
import br.com.bdcadastro.sistemaempresarial.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
