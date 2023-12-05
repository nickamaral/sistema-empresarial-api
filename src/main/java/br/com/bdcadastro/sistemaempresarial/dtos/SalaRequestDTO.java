package br.com.bdcadastro.sistemaempresarial.dtos;

import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.SalaEntity;
import br.com.bdcadastro.sistemaempresarial.enums.StatusDoCliente;
import br.com.bdcadastro.sistemaempresarial.enums.TipoSala;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaRequestDTO {
    @NotEmpty(message = "O campo responsavel não pode estar vazio")
    private String responsavel;
    @NotEmpty(message = "O campo número não pode estar vazio")
    private String numero;
    @NotEmpty(message = "O campo andar não pode estar vazio")
    private String andar;
    @NotEmpty(message = "O campo empresa não pode estar vazio")
    private String empresa;
    @NotEmpty(message = "O campo cnpj não pode estar vazio")
    @CNPJ(message = "Deve ser um CNPJ validado")
    private String cnpj;
    @NotEmpty(message = "O campo tipo sala não pode estar vazio")
    private String tipoSala;

    @AssertTrue // assegura que o metodo vai dar verdadeiro
    public boolean isValidoResponsavel(){
        return responsavel!=null
                &&responsavel.contains(" ")
                &&responsavel.length()>=4
                &&!responsavel.isBlank();
    }

    public SalaEntity converterNaEntidade() {
        return SalaEntity.builder()
                .responsavel(responsavel)
                .cnpj(cnpj)
                .andar(andar)
                .cnpj(trataCnpj(cnpj))
                .tipoSala(TipoSala.pegaTipoSala(tipoSala))
                .empresa(empresa)
                .numero(numero)
                .build();
    }

    private String trataCnpj(String cnpj) {
            return cnpj.replaceAll("[^0-9]","");
        }
    }

