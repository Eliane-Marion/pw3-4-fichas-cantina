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

    @Enumerated(EnumType.STRING)
    @Column(name = "BO_STATUS")
    private StatusRole status;

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public StatusRole getStatus() {
        return status;
    }

    public void setStatus(StatusRole status) {
        this.status = status;
    }
}
