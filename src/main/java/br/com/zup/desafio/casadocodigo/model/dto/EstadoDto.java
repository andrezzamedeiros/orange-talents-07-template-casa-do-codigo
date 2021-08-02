package br.com.zup.desafio.casadocodigo.model.dto;

import br.com.zup.desafio.casadocodigo.model.Estado;
import br.com.zup.desafio.casadocodigo.model.Pais;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

public class EstadoDto {


    private String nome;
    private String pais;

    public EstadoDto(Estado estado) {
        this.nome = estado.getNome();
        this.pais = estado.getPais().getNome();
    }

    public String getNome() {
        return nome;
    }
}

