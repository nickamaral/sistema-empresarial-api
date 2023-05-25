package br.com.bdcadastro.sistemaempresarial.controllers;

import br.com.bdcadastro.sistemaempresarial.entities.UsuarioEntity;
import br.com.bdcadastro.sistemaempresarial.repositories.UsuarioRepository;
import br.com.bdcadastro.sistemaempresarial.dtos.UsuarioRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping
    public List<UsuarioEntity> listaTodosOsUsuarios(){
        return usuarioRepository.findAll();
    }
    @GetMapping("/{id}")
    public UsuarioEntity buscaPorId(@PathVariable Long id){
        return usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("usuario não encontrado"));
    }
    @DeleteMapping("/{id}")
    public void deletePorId(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }
    @GetMapping("/cpf/{cpf}")
    public UsuarioEntity buscaPorCPF(@PathVariable String cpf){
        return usuarioRepository.findByCpf(cpf).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }
    @PostMapping
    public UsuarioEntity criaCliente(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO){
        if(usuarioRepository.findByCpf(usuarioRequestDTO.getCpf()).isPresent()){
            throw new RuntimeException("CPF já cadastrado");
        }
        return usuarioRepository.save(usuarioRequestDTO.converterNaEntidade());
    }

}
