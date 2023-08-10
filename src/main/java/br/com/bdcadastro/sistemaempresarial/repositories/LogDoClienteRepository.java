package br.com.bdcadastro.sistemaempresarial.repositories;

import br.com.bdcadastro.sistemaempresarial.entities.ClienteEntity;
import br.com.bdcadastro.sistemaempresarial.entities.LogDoClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogDoClienteRepository extends JpaRepository<LogDoClienteEntity,Long> {


    List<LogDoClienteEntity> findAllByOrderByIdDesc();
    List<LogDoClienteEntity> findAllByCpfDoClienteOrderByIdDesc(String cpfDoCliente);
}
