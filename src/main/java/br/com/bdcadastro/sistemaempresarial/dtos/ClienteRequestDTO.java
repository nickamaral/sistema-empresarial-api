package br.com.bdcadastro.sistemaempresarial.dtos;

import br.com.bdcadastro.sistemaempresarial.enums.StatusDoCliente;
import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

//Data transfer object Objeto de transferência de dados (json)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {
    @NotEmpty(message = "O campo email não pode estar vazio")
    @Email(message = "Formato adequado")
    private String email;
    @NotEmpty(message = "O campo nome não pode estar vazio")
    private String nome;
    @NotEmpty(message = "O campo idade não pode estar vazio")
    @Pattern(regexp = "[0-9]+",message = "Somente números")
    private String idade;
    @NotEmpty(message = "O campo endereço não pode estar vazio")
    private String endereco;
    @NotEmpty(message = "O campo cpf não pode estar vazio")
    @CPF(message = "Deve ter o formato de um CPF")
    private String cpf;
    @NotEmpty(message = "O campo telefone não pode estar vazio")
    @Pattern(regexp = "[0-9]+",message = "Somente números")
    private String telefone;
    @AssertTrue(message = "Deve ser passado um número de telefone celular")
    public boolean isTelefoneCelular(){
        int posicaoDo9NoCelular = 2;
        return telefone.charAt(posicaoDo9NoCelular) == '9';
    }
    @AssertTrue(message = "Deve ser passado um número de telefone com 11 números")
    public boolean hasTamanhoTelefoneCelular(){
        int tamanhoNumeroCelular = 11;
        return telefone.length() == tamanhoNumeroCelular;
    }

    @AssertFalse(message = "Deve ser passado um número de telefone celular válido")
    public boolean hasEspacamentoNoTelefoneCelular(){
    return telefone.contains(" ");

    }
    public ClienteEntity converterNaEntidade() {
        return ClienteEntity.builder()
                .nome(nome)
                .idade(idade)
                .email(email)
                .cpf(trataCpf(cpf))
                .telefone(telefone)
                .endereco(endereco)
                .statusDoCliente(StatusDoCliente.PRESENTE)
                .build();
    }

    public String getCpf() {
        return trataCpf(cpf);
    }

    private String trataCpf(String cpf) {
        return cpf.replaceAll("[^0-9]","");
    }

    @AssertTrue // assegura que o metodo vai dar verdadeiro
    public boolean isValidoNome(){
        return nome!=null
                &&nome.contains(" ")
                &&nome.length()>=4
                &&!nome.isBlank();
    }
    @AssertTrue // assegura que o metodo vai dar verdadeiro
    public boolean isValidoEmail(){
        return email!=null;
    }


}
