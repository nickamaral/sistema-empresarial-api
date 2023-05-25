package br.com.bdcadastro.sistemaempresarial.entities;

import br.com.bdcadastro.sistemaempresarial.dtos.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String telefone;
    private String email;
    private String senha;
    private String cpf;


    public void atualizaCampos(UsuarioRequestDTO usuarioRequestDTO) {
        this.email = usuarioRequestDTO.getEmail();
        this.nome = usuarioRequestDTO.getNome();
        this.idade = usuarioRequestDTO.getIdade();
        this.cpf = usuarioRequestDTO.getCpf();
        this.telefone = usuarioRequestDTO.getTelefone();
    }
}

