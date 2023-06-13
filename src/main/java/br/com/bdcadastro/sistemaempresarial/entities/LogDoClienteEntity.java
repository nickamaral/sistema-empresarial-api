package br.com.bdcadastro.sistemaempresarial.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs_clientes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LogDoClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoCliente;
    private String cpfDoCliente;
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private StatusDoLog statusDoLog;
    private String sala;
}
