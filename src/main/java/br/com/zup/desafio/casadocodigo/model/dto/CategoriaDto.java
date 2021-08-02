package br.com.zup.desafio.casadocodigo.model.dto;

import br.com.zup.desafio.casadocodigo.model.Categoria;

public class CategoriaDto {

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
