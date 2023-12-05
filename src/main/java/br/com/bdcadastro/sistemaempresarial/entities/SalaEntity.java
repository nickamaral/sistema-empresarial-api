package br.com.bdcadastro.sistemaempresarial.entities;

import br.com.bdcadastro.sistemaempresarial.dtos.ClienteRequestDTO;
import br.com.bdcadastro.sistemaempresarial.dtos.SalaRequestDTO;
import br.com.bdcadastro.sistemaempresarial.dtos.SalaResponseDTO;
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
    public SalaResponseDTO converteParaDTO(){
        return SalaResponseDTO.converte(this);
    }

    public void atualizaCampos(SalaRequestDTO salaRequestDTO) {
        this.responsavel= salaRequestDTO.getResponsavel();
        this.numero= salaRequestDTO.getNumero();
        this.andar= salaRequestDTO.getAndar();
        this.empresa= salaRequestDTO.getEmpresa();
        this.cnpj= salaRequestDTO.getCnpj();
        this.tipoSala= TipoSala.pegaTipoSala(salaRequestDTO.getTipoSala());
    }
}