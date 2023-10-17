package br.com.bdcadastro.sistemaempresarial.services;

import br.com.bdcadastro.sistemaempresarial.ClienteNaoEncontradoException;
import br.com.bdcadastro.sistemaempresarial.dtos.ClienteInfosResponseDTO;
import br.com.bdcadastro.sistemaempresarial.dtos.LogDoClienteInformacesResponseDTO;
import br.com.bdcadastro.sistemaempresarial.dtos.StatusDoClienteRequestDTO;
import br.com.bdcadastro.sistemaempresarial.entities.LogDoClienteEntity;
import br.com.bdcadastro.sistemaempresarial.repositories.ClienteRepository;
import br.com.bdcadastro.sistemaempresarial.dtos.ClienteRequestDTO;
import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired private LogDoClienteService logDoClienteService;
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }
    public ClienteEntity buscaPorIdOuJogaException(Long id){
        return clienteRepository.findById(id).orElseThrow(ClienteNaoEncontradoException::new);
    }

    public ClienteEntity buscaPorId(Long id) {
        return buscaPorIdOuJogaException(id);
    }

    public ClienteEntity criaCliente(ClienteRequestDTO clienteRequestDTO) {
        if(clienteRepository.findByCpf(clienteRequestDTO.getCpf()).isPresent()){
            throw new RuntimeException("CPF já cadastrado no sistema");
        }
        return clienteRepository.save(clienteRequestDTO.converterNaEntidade());
    }

    @Transactional // grande mudança no banco de dados
    public void deleteById(Long id) {
        ClienteEntity cliente = buscaPorIdOuJogaException(id);
        clienteRepository.deleteById(id);
    }

    public void deleteAll() {
        clienteRepository.deleteAll();
    }

    public ClienteEntity findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).orElseThrow(ClienteNaoEncontradoException::new);
    }

    public ClienteEntity findByTelefone(String telefone) {
        return clienteRepository.findByTelefone(telefone).orElseThrow(ClienteNaoEncontradoException::new);
    }

    public void atualiza(Long id, ClienteRequestDTO clienteRequestDTO) {
        ClienteEntity clienteParaAlterar = buscaPorIdOuJogaException(id);
        clienteParaAlterar.atualizaCampos(clienteRequestDTO);
        clienteRepository.save(clienteParaAlterar);
    }

    public void alteraStatusDoCliente(Long id, StatusDoClienteRequestDTO statusDTO) {
        ClienteEntity cliente = buscaPorIdOuJogaException(id);
        logDoClienteService.marcaLogDoCliente(cliente,statusDTO);
        cliente.alteraStatus(statusDTO);
        clienteRepository.save(cliente);

    }

    public ClienteInfosResponseDTO pegaInformacoesCliente(Long id) {
        ClienteEntity cliente = buscaPorIdOuJogaException(id);
        LogDoClienteInformacesResponseDTO logDoClienteDTO = logDoClienteService.pegaUltimoLogDoCliente(cliente);
        return ClienteInfosResponseDTO.of(cliente, logDoClienteDTO);
    }
}
