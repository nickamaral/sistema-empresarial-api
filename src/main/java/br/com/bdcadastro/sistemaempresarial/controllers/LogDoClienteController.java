package br.com.bdcadastro.sistemaempresarial.controllers;

import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.LogDoClienteEntity;
import br.com.bdcadastro.sistemaempresarial.services.ClienteService;
import br.com.bdcadastro.sistemaempresarial.services.LogDoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes-log")
public class LogDoClienteController {
    @Autowired //Spring ingetar a classe
    private LogDoClienteService logDoClienteService;

    @GetMapping
    public List<LogDoClienteEntity> listTodosOsLogsDosdClientes() {return logDoClienteService.findAll();
    }
}
