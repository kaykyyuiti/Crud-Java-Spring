package com.template.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lutadores")
public class Lutador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", unique = true, length = 200, nullable = false)
    private String nome;

    @Column(name = "categoria", length = 100, nullable = false)
    private String categoria;

    @Column(name = "genero", length = 50, nullable = false)
    private String genero;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "sequencia_vitorias")
    private Integer sequenciaVitorias;
}