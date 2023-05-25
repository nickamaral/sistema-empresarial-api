package br.com.bdcadastro.sistemaempresarial.controllers;

import br.com.bdcadastro.sistemaempresarial.dtos.StatusDoClienteRequestDTO;
import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.dtos.ClienteRequestDTO;
import br.com.bdcadastro.sistemaempresarial.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired //Spring ingetar a classe
    private ClienteService clienteService;

    @GetMapping
    public List <ClienteEntity> listTodosOsClientes(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ClienteEntity buscaPorId(@PathVariable Long id){ //PathVariable ele relaciona a variavel com o conteúdo da url, nesse caso o /{id} que foi mapeado
         return clienteService.buscaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletePorId(@PathVariable Long id){clienteService.deleteById(id);}

    @PostMapping
    public ClienteEntity criaCliente(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO) {
        return clienteService.criaCliente(clienteRequestDTO);
    }

    @DeleteMapping
    public void deletaTodos(){clienteService.deleteAll();
    }

    @GetMapping("/cpf/{cpf}")
    public ClienteEntity buscaPorCPF(@PathVariable String cpf){
        return clienteService.findByCpf(cpf);
    }

    @GetMapping("/telefone/{telefone}")
    public ClienteEntity buscaPorTelefone(@PathVariable String telefone){
        return clienteService.findByTelefone(telefone);
    }

    @PutMapping("/{id}")
    public void alteraPorId(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO clienteRequestDTO){
        clienteService.atualiza(id, clienteRequestDTO);
    }
    @PostMapping("/{id}/status")
    public void alteraStatusDoCliente(@PathVariable Long id, @RequestBody @Valid StatusDoClienteRequestDTO statusDTO){
        clienteService.alteraStatusDoCliente(id, statusDTO);
    }

}


