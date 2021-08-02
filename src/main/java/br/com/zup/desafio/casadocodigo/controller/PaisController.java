package br.com.zup.desafio.casadocodigo.controller;

import br.com.zup.desafio.casadocodigo.Repository.PaisRepository;
import br.com.zup.desafio.casadocodigo.model.Livro;
import br.com.zup.desafio.casadocodigo.model.Pais;
import br.com.zup.desafio.casadocodigo.model.dto.LivroDto;
import br.com.zup.desafio.casadocodigo.model.dto.PaisDto;
import br.com.zup.desafio.casadocodigo.model.form.LivroForm;
import br.com.zup.desafio.casadocodigo.model.form.PaisForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisForm paisForm) {
        Pais pais = paisForm.converter();
        paisRepository.save(pais);
        return ResponseEntity.ok(new PaisDto(pais));
    }
}
