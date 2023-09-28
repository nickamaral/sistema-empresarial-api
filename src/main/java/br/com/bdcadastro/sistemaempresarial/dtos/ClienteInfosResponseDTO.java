package br.com.bdcadastro.sistemaempresarial.dtos;

import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteInfosResponseDTO {
    private String email;
    private String nome;
    private String idade;
    private String cpf;
    private String telefone;
    private String sala;
    private String endereco;
    private String urlFoto;
    private String statusDoCliente;
    private LocalDateTime dataHora;

    public static ClienteInfosResponseDTO of(ClienteEntity cliente, LogDoClienteInformacesResponseDTO logDoClienteDTO) {
        return new ClienteInfosResponseDTOBuilder().cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .idade(cliente.getIdade())
                .urlFoto(cliente.getUrlFoto())
                .endereco(cliente.getEndereco())
                .dataHora(logDoClienteDTO.getDataHora())
                .sala(logDoClienteDTO.getSala())
                .statusDoCliente(pegaStatusDoCliente(logDoClienteDTO))
                .build();

    }

    private static String pegaStatusDoCliente(LogDoClienteInformacesResponseDTO logDoClienteDTO) {
        if (logDoClienteDTO.getStatusDoLog()==null){
            return "nunca entrou";
        }else {
            return logDoClienteDTO.getStatusDoLog().getDescription();
        }
    }
}
