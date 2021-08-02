package br.com.zup.desafio.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotNull
    private String nome;

    @ManyToOne
    @NotNull
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
