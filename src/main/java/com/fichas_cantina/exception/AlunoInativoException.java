package com.fichas_cantina.exception;

public class AlunoInativoException extends RuntimeException {

    public AlunoInativoException(Long id) {
        super("Aluno com id: " + id + " está inativo e não pode executar a operação.");
    }
}
