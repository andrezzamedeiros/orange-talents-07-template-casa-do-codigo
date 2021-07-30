package br.com.zup.desafio.casadocodigo.model.form;

import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.Repository.CategoriaRepository;
import br.com.zup.desafio.casadocodigo.model.Autor;
import br.com.zup.desafio.casadocodigo.model.Categoria;
import br.com.zup.desafio.casadocodigo.model.Livro;
import br.com.zup.desafio.casadocodigo.validacao.ExistsId;
import br.com.zup.desafio.casadocodigo.validacao.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LivroForm {

    @NotNull @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotNull @NotBlank
    private String resumo;
    @NotNull @NotBlank @Lob
    private String sumario;
    @NotNull @Min(20)
    private Double preco;
    @NotNull @Min(100)
    private Integer nPaginas;
    @NotNull @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotNull @Future
    private LocalDateTime dataPublicacao;

    @NotNull @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    @NotNull @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public LivroForm(String titulo, String resumo, String sumario, Double preco, Integer nPaginas, String isbn, LocalDateTime dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.nPaginas = nPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
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

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long geIdAutor() {
        return idAutor;
    }

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository){
        @NotNull Categoria categoria =categoriaRepository.getById(this.idCategoria);
        @NotNull Autor autor = autorRepository.getById(this.idAutor);
        Assert.state(autor!=null, "Autor informado não existe!");
        Assert.state(categoria!=null, "Categoria informada não existe!");
        return new Livro(titulo, resumo, sumario, preco, nPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
