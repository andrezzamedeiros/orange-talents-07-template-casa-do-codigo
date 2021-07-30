package br.com.zup.desafio.casadocodigo.model.dto;

import br.com.zup.desafio.casadocodigo.model.Categoria;
import br.com.zup.desafio.casadocodigo.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaDto {

    @NotNull
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public CategoriaDto() {
    }

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }
    public CategoriaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
