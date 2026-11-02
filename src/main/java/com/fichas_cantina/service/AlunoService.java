package com.fichas_cantina.service;

import com.fichas_cantina.entity.Aluno;
import com.fichas_cantina.enums.StatusRole;
import com.fichas_cantina.exception.AlunoInativoException;
import com.fichas_cantina.exception.AlunoNaoEncontradoException;
import com.fichas_cantina.exception.SaldoInsufficienteException;
import com.fichas_cantina.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listar() {
        return repository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AlunoNaoEncontradoException(id));
    }

    public Aluno criar(Aluno aluno) {
        if (aluno.getStatus() == null) {
            aluno.setStatus(StatusRole.ATIVO);
        }
        return repository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno dados) {
        Aluno aluno = buscarPorId(id);
        aluno.setNomeAluno(dados.getNomeAluno());
        aluno.setSaldo(dados.getSaldo());
        return repository.save(aluno);
    }

    public Aluno deletar(Long id) {
        Aluno aluno = buscarPorId(id);
        aluno.setStatus(StatusRole.INATIVO);
        return repository.save(aluno);
    }

    public Aluno debitarSaldo(Long id, Double valor) {
        Aluno aluno = buscarPorId(id);

        if (aluno.getStatus() != StatusRole.ATIVO) {
            throw new AlunoInativoException(id);
        }

        if (aluno.getSaldo() == null || aluno.getSaldo() < valor) {
            throw new SaldoInsufficienteException();
        }

        aluno.setSaldo(aluno.getSaldo() - valor);
        return repository.save(aluno);
    }

    public Aluno recarregarSaldo(Long id, Double valor) {
        Aluno aluno = buscarPorId(id);

        double saldoAtual = aluno.getSaldo() == null ? 0.0 : aluno.getSaldo();
        aluno.setSaldo(saldoAtual + valor);
        return repository.save(aluno);
    }
}
