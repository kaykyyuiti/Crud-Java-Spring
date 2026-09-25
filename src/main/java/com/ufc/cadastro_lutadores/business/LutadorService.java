package com.ufc.cadastro_lutadores.business;

import com.template.model.entity.Lutador;
import com.ufc.cadastro_lutadores.infrastructure.repository.LutadorRepository;
import org.springframework.stereotype.Service;

@Service
public class LutadorService {

    private final LutadorRepository repository;

    public LutadorService(LutadorRepository repository) {
        this.repository = repository;
    }

    public void salvarLutador(Lutador lutador) {
        repository.saveAndFlush(lutador);
    }

    public Lutador buscarLutadorPorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado!")
        );
    }
}