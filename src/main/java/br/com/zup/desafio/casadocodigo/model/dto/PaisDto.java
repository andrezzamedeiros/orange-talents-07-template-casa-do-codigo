package br.com.zup.desafio.casadocodigo.model.dto;

import br.com.zup.desafio.casadocodigo.model.Estado;
import br.com.zup.desafio.casadocodigo.model.Pais;
import br.com.zup.desafio.casadocodigo.validacao.annotations.UniqueValue;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class PaisDto {

    private String nome;


    public PaisDto(Pais pais) {
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }

}
