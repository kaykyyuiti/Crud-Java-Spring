package com.ufc.cadastro_lutadores.business;

import com.ufc.cadastro_lutadores.infrastructure.entity.Lutador;
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

    public void deletarLutadorPorNome(String nome) {
        repository.deleteByNome(nome);
    }

    public void atualizarLutadorPorId(Integer id, Lutador lutador) {
        Lutador lutadorEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Lutador não encontrado"));
        Lutador lutadorAtualizado = Lutador.builder()
                .nome(lutador.getNome() != null ? lutador.getNome() :
                        lutadorEntity.getNome())
                .categoria(lutador.getCategoria() != null ? lutador.getCategoria() :
                        lutadorEntity.getCategoria())
                .genero(lutador.getGenero() != null ? lutador.getGenero() :
                        lutadorEntity.getGenero())
                .idade(lutador.getIdade() != null ? lutador.getIdade() :
                        lutadorEntity.getIdade())
                .sequenciaVitorias(lutador.getSequenciaVitorias() != null ? lutador.getSequenciaVitorias() :
                        lutadorEntity.getSequenciaVitorias())
                .id(lutadorEntity.getId())
                .build();

        repository.saveAndFlush(lutadorAtualizado);
    }
}