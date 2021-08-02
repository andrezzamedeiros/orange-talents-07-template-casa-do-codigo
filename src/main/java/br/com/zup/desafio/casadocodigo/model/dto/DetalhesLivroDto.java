package br.com.zup.desafio.casadocodigo.model.dto;

import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.model.Autor;
import br.com.zup.desafio.casadocodigo.model.Categoria;
import br.com.zup.desafio.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import java.time.LocalDateTime;
import java.util.Optional;

public class DetalhesLivroDto {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer nPaginas;
    private String isbn;
   private DetalhesAutorDto detalhesAutor;

    public DetalhesLivroDto(Livro livro) {
        this.id = livro.getId();
        this.detalhesAutor = new DetalhesAutorDto(livro.getAutor());
        this.resumo = livro.getResumo();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.nPaginas = livro.getnPaginas();
        this.preco = livro.getPreco();
        this.sumario = livro.getSumario();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getnPaginas() {
        return nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public DetalhesAutorDto getAutorDto() {
        return detalhesAutor;
    }
}

