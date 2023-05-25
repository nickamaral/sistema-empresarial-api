package br.com.bdcadastro.sistemaempresarial.entities;

import br.com.bdcadastro.sistemaempresarial.dtos.ClienteRequestDTO;
import br.com.bdcadastro.sistemaempresarial.StatusDoCliente;
import br.com.bdcadastro.sistemaempresarial.dtos.StatusDoClienteRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    private String idade;
    private String cpf;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private StatusDoCliente statusDoCliente;


    public void atualizaCampos(ClienteRequestDTO clienteRequestDTO) {
        this.email=clienteRequestDTO.getEmail();
        this.nome=clienteRequestDTO.getNome();
        this.idade=clienteRequestDTO.getIdade();
        this.cpf=clienteRequestDTO.getCpf();
        this.telefone=clienteRequestDTO.getTelefone();

    }

    public void alteraStatus(StatusDoClienteRequestDTO statusDTO) {
        this.statusDoCliente=statusDTO.getStatus();
    }


}


