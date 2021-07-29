package br.com.zup.desafio.casadocodigo.controller;

import br.com.zup.desafio.casadocodigo.Repository.CategoriaRepository;
import br.com.zup.desafio.casadocodigo.model.Categoria;
import br.com.zup.desafio.casadocodigo.model.dto.CategoriaDto;
import br.com.zup.desafio.casadocodigo.validacao.ValidaCategoriaDuplicada;
import br.com.zup.desafio.casadocodigo.validacao.ValidaEmailDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    private ValidaCategoriaDuplicada validaCategoriaDuplicada;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validaCategoriaDuplicada);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrar (@RequestBody @Valid Categoria categoria){
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(new CategoriaDto(categoria));
    }
}
