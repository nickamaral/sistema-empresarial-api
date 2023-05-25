package br.com.bdcadastro.sistemaempresarial.repositories;

import br.com.bdcadastro.sistemaempresarial.entities.LogDoClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDoClienteRepository extends JpaRepository<LogDoClienteEntity,Long> {
}
