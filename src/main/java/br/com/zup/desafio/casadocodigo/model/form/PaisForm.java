package br.com.zup.desafio.casadocodigo.model.form;

import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.Repository.CategoriaRepository;
import br.com.zup.desafio.casadocodigo.model.*;
import br.com.zup.desafio.casadocodigo.validacao.annotations.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class PaisForm {

    @NotNull
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisForm() {
    }

    public PaisForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Pais converter(){
        return new Pais(this.nome);
    }
}
