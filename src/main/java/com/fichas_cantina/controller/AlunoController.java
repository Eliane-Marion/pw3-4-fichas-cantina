package com.fichas_cantina.controller;

import com.fichas_cantina.dto.ValorRequest;
import com.fichas_cantina.entity.Aluno;
import com.fichas_cantina.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deletar(@PathVariable Long id) {
        return ResponseEntity.ok(service.deletar(id));
    }

    @PostMapping("/{id}/debitar")
    public ResponseEntity<Aluno> debitar(@PathVariable Long id, @RequestBody ValorRequest request) {
        return ResponseEntity.ok(service.debitarSaldo(id, request.getValor()));
    }

    @PostMapping("/{id}/recarregar")
    public ResponseEntity<Aluno> recarregar(@PathVariable Long id, @RequestBody ValorRequest request) {
        return ResponseEntity.ok(service.recarregarSaldo(id, request.getValor()));
    }
}
