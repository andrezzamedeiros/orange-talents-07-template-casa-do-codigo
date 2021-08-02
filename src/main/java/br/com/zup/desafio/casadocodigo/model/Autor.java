package br.com.zup.desafio.casadocodigo.model;


import br.com.zup.desafio.casadocodigo.validacao.annotations.UniqueValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    private LocalDate instante = LocalDate.now();
    @NotNull
    @NotBlank
    private String descricao;

    @Deprecated
    public Autor() {
    }

    public Autor(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getInstante() {
        return instante;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

}
