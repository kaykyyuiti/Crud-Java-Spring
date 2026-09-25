package com.ufc.cadastro_lutadores.infrastructure.repository;

import com.template.model.entity.Lutador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {

    Optional<Lutador> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}