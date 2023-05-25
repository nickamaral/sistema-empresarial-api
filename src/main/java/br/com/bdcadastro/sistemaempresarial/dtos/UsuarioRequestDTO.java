package br.com.bdcadastro.sistemaempresarial.dtos;

import br.com.bdcadastro.sistemaempresarial.entities.UsuarioEntity;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    @NotEmpty(message = "O campo email não pode estar vazio")
    @Email(message = "Formato adequado")
    private String email;
    @NotEmpty(message = "O campo nome não pode estar vazio")
    private String nome;
    @NotEmpty(message = "O campo idade não pode estar vazio")
    @Pattern(regexp = "[0-9]+",message = "Somente números")
    private String idade;
    @NotEmpty(message = "O campo cpf não pode estar vazio")
    @CPF(message = "Deve ter o formato de um CPF")
    private String cpf;
    @NotEmpty(message = "O campo telefone não pode estar vazio")
    @Pattern(regexp = "[0-9]+",message = "Somente números")
    private String telefone;

    public UsuarioEntity converterNaEntidade() {
        return UsuarioEntity.builder()
                .nome(nome)
                .idade(idade)
                .email(email)
                .cpf(cpf)
                .telefone(telefone)
                .build();
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

