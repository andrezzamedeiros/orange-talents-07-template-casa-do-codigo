package br.com.zup.desafio.casadocodigo.model;

import br.com.zup.desafio.casadocodigo.validacao.annotations.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotNull
    private String nome;

    @Deprecated
    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
