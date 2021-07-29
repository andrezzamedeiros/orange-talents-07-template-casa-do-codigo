package br.com.zup.desafio.casadocodigo.controller;


import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.model.Autor;
import br.com.zup.desafio.casadocodigo.model.dto.AutorDto;
import br.com.zup.desafio.casadocodigo.model.form.AutorForm;
import br.com.zup.desafio.casadocodigo.validacao.ValidaEmailDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;

@RestController
@Validated
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ValidaEmailDuplicado validaEmailDuplicado;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validaEmailDuplicado);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder) throws Exception {

      if(autorForm.getDescricao().length() > 400){
          throw new IllegalArgumentException("Descrição não pode ser maior que 400");
      }
      Autor autor = autorForm.convertAutor();

        autorRepository.save(autor);
        URI uri = uriBuilder.path("/autores{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.ok().body(new AutorDto(autor));
    }
}
