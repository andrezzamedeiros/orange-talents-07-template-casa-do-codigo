package br.com.zup.desafio.casadocodigo.controller;

import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.Repository.CategoriaRepository;
import br.com.zup.desafio.casadocodigo.Repository.LivroRepository;
import br.com.zup.desafio.casadocodigo.model.Autor;
import br.com.zup.desafio.casadocodigo.model.Livro;
import br.com.zup.desafio.casadocodigo.model.dto.DetalhesLivroDto;
import br.com.zup.desafio.casadocodigo.model.dto.LivroDto;
import br.com.zup.desafio.casadocodigo.model.form.LivroForm;
import br.com.zup.desafio.casadocodigo.validacao.exceptions.NotFoundExceptionDefault;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroForm livroForm) {
            Livro livro = livroForm.converter(autorRepository, categoriaRepository);
            livroRepository.save(livro);
            return ResponseEntity.ok(new LivroDto(livro));
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> listaTodos() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok().body(LivroDto.converter(livros));
    }

    @GetMapping("/{id}/{nomeAutor}")
    public ResponseEntity<DetalhesLivroDto> listaPorId(@PathVariable Long id, @PathVariable String nomeAutor) throws NotFoundException {

        Optional<Livro> livro = livroRepository.findById(id);
        if(!livro.isPresent()){
            throw new NotFoundException("Livro não encontrado");
        }
        Optional<Autor> autor = autorRepository.findByNome(nomeAutor);
        if(!autor.isPresent()){
            throw new NotFoundException("Autor não encontrado");
        }
        return ResponseEntity.ok(new DetalhesLivroDto(livro.get(), autor.get()));
    }
}