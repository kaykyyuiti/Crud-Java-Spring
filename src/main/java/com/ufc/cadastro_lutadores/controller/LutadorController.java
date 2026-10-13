package com.ufc.cadastro_lutadores.controller;

import com.ufc.cadastro_lutadores.business.LutadorService;
import com.ufc.cadastro_lutadores.infrastructure.entity.Lutador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Lutador")
@RequiredArgsConstructor

public class LutadorController {

    private final LutadorService lutadorService;

    @PostMapping
    public ResponseEntity<Void> salvarLutador(@RequestBody Lutador lutador){
        lutadorService.salvarLutador(lutador);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Lutador> buscarLutadorPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(lutadorService.buscarLutadorPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorNome(@RequestParam String nome) {
        lutadorService.deletarLutadorPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestBody Lutador lutador,
                                                        @RequestParam Integer id) {
        lutadorService.atualizarLutadorPorId(id, lutador);
        return ResponseEntity.ok().build();
    }


}
