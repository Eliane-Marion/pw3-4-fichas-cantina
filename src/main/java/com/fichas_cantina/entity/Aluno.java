package com.fichas_cantina.entity;

import com.fichas_cantina.enums.StatusRole;
import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUNO")
    private Long idAluno;

    @Column(name = "TX_NOME_ALUNO")
    private String nomeAluno;

    @Column(name = "NR_MATRICULA")
    private Integer matricula;

    @Column(name = "NR_SALDO")
    private Double saldo;

    @Column(name = "BO_STATUS")
    private StatusRole status;
}
