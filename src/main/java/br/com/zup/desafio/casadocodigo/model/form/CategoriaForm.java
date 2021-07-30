package br.com.zup.desafio.casadocodigo.model.form;

import br.com.zup.desafio.casadocodigo.model.Categoria;
import br.com.zup.desafio.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaForm {

    @NotNull
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;


    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converter(){
        return new Categoria(nome);
    }
}

