package br.com.bdcadastro.sistemaempresarial.dtos;

import br.com.bdcadastro.sistemaempresarial.StatusDoCliente;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusDoClienteRequestDTO {
    @NotNull(message = "Um status deve ser informado")
    private StatusDoCliente status;
    private String sala;
}
