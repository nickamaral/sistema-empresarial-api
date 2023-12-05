package br.com.bdcadastro.sistemaempresarial.dtos;

import br.com.bdcadastro.sistemaempresarial.entities.SalaEntity;
import br.com.bdcadastro.sistemaempresarial.enums.TipoSala;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaResponseDTO {
    private Long id;
    private String responsavel;
    private String numero;
    private String andar;
    private String empresa;
    private String cnpj;
    private String tipoSala;

    public static SalaResponseDTO converte(SalaEntity salaEntity) {
        return SalaResponseDTO.builder()
                .id(salaEntity.getId())
                .responsavel(salaEntity.getResponsavel())
                .andar(salaEntity.getAndar())
                .empresa(salaEntity.getEmpresa())
                .numero(salaEntity.getNumero())
                .cnpj(salaEntity.getCnpj())
                .tipoSala(salaEntity.getTipoSala().getDescricao())
                .build();
    }
}
