package br.com.zup.desafio.casadocodigo.model.form;

import br.com.zup.desafio.casadocodigo.Repository.PaisRepository;
import br.com.zup.desafio.casadocodigo.model.Estado;
import br.com.zup.desafio.casadocodigo.model.Pais;
import br.com.zup.desafio.casadocodigo.validacao.annotations.ExistsId;
import br.com.zup.desafio.casadocodigo.validacao.annotations.UniqueValue;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public EstadoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public Long idPais() {
        return idPais;
    }

    public Estado converter(PaisRepository paisRepository){
        Pais pais = paisRepository.getById(idPais);
        return new Estado(nome, pais);
    }
}