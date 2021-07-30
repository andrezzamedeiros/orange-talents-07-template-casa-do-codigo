package br.com.zup.desafio.casadocodigo.controller;

import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.Repository.CategoriaRepository;
import br.com.zup.desafio.casadocodigo.Repository.LivroRepository;
import br.com.zup.desafio.casadocodigo.model.Livro;
import br.com.zup.desafio.casadocodigo.model.dto.LivroDto;
import br.com.zup.desafio.casadocodigo.model.form.LivroForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
}