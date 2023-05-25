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
    @ManyToOne
    private ClienteEntity cliente;
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private StatusDoLog statusDoLog;
    private String sala;
}
