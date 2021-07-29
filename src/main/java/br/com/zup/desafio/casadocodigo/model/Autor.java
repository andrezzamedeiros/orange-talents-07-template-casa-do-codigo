package br.com.zup.desafio.casadocodigo.model;


import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.model.form.AutorForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome não pode ser nulo") @NotEmpty(message = "O nome não pode estar vazio")
    private String nome;
    @NotNull(message = "Email não pode ser nulo") @NotEmpty(message = "O email não pode estar vazio")
    private String email;
    private LocalDate instante = LocalDate.now();
    @NotNull(message = "A descrição não pode ser nula") @NotEmpty(message = "A descrição não pode estar vazia")
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
