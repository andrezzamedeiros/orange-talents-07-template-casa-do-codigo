package br.com.zup.desafio.casadocodigo.model.form;

import br.com.zup.desafio.casadocodigo.model.Autor;
import br.com.zup.desafio.casadocodigo.validacao.annotations.UniqueValue;

import javax.validation.constraints.*;

public class AutorForm {

    private Long id;
    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;
    @NotNull(message = "Email não pode ser nulo")
    @NotBlank(message = "O email não pode estar vazio")
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode estar vazia")
    private String descricao;


    public AutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor convertAutor() {
        return new Autor(this.nome, this.email, this.descricao);

    }
}
