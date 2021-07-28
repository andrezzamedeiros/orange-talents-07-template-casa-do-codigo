package br.com.zup.desafio.casadocodigo.model.dto;

import br.com.zup.desafio.casadocodigo.model.Autor;

import java.io.Serializable;

public class AutorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String descricao;
    private String nome;

    public AutorDto(Autor autor){
        this.descricao = autor.getDescricao();
        this.nome = autor.getNome();
    }
}
