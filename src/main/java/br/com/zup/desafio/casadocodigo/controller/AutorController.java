package br.com.zup.desafio.casadocodigo.controller;


import br.com.zup.desafio.casadocodigo.Repository.AutorRepository;
import br.com.zup.desafio.casadocodigo.model.Autor;
import br.com.zup.desafio.casadocodigo.model.dto.AutorDto;
import br.com.zup.desafio.casadocodigo.model.form.AutorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@Validated
@RequestMapping("/autores2")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder){

      if(autorForm.getDescricao().length() > 400){
          throw new IllegalArgumentException("Descrição não pode ser maior que 400");
      }
        Autor autor = autorForm.convertAutor();
        Autor autor1 = autorRepository.save(autor);
        //URI uri = uriBuilder.path("/autores{id}").buildAndExpand(autor1.getId()).toUri();
        return ResponseEntity.ok(new AutorDto(autor1));
    }
}
