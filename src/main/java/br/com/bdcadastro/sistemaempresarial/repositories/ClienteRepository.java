package br.com.bdcadastro.sistemaempresarial.repositories;

import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
    Optional<ClienteEntity> findByCpf(String cpf);
    Optional<ClienteEntity> findByTelefone(String telefone);
}

