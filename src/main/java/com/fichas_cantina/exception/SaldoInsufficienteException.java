package com.fichas_cantina.exception;

public class SaldoInsufficienteException extends RuntimeException {

    public SaldoInsufficienteException() {
        super("Saldo insuficiente para realizar a operação.");
    }
}
