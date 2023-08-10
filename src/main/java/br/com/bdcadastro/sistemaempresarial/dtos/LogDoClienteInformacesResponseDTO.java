package br.com.bdcadastro.sistemaempresarial.dtos;

import br.com.bdcadastro.sistemaempresarial.entities.StatusDoLog;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogDoClienteInformacesResponseDTO {
    private LocalDateTime dataHora;
    private StatusDoLog statusDoLog;
    private String sala;

    public static LogDoClienteInformacesResponseDTO criaDTOVazio() {
        return LogDoClienteInformacesResponseDTO.builder()
                .sala(null)
                .dataHora(null)
                .statusDoLog(null)
                .build();
    }
}
