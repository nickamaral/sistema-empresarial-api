package br.com.bdcadastro.sistemaempresarial.repositories;

import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.SalaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalaRepository extends JpaRepository<SalaEntity,Long> {

    Optional<SalaEntity> findByNumero(String numero);

}
