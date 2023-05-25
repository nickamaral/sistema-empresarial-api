package br.com.bdcadastro.sistemaempresarial.repositories;

import br.com.bdcadastro.sistemaempresarial.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
    Optional<UsuarioEntity> findByCpf(String cpf);
    Optional<UsuarioEntity> findByTelefone(String telefone);
}
