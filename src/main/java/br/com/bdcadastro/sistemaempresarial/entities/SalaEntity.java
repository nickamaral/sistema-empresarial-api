package br.com.bdcadastro.sistemaempresarial.entities;

import br.com.bdcadastro.sistemaempresarial.enums.StatusDoCliente;
import br.com.bdcadastro.sistemaempresarial.enums.TipoSala;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_salas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String responsavel;
    private String numero;
    private String andar;
    private String empresa;
    private String cnpj;
    @Enumerated(EnumType.STRING)
    private TipoSala tipoSala;
}