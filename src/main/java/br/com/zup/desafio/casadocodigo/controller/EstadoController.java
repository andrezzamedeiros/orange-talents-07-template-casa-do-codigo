package br.com.zup.desafio.casadocodigo.controller;

import br.com.zup.desafio.casadocodigo.Repository.EstadoRepository;
import br.com.zup.desafio.casadocodigo.Repository.PaisRepository;
import br.com.zup.desafio.casadocodigo.model.Estado;
import br.com.zup.desafio.casadocodigo.model.Pais;
import br.com.zup.desafio.casadocodigo.model.dto.EstadoDto;
import br.com.zup.desafio.casadocodigo.model.dto.PaisDto;
import br.com.zup.desafio.casadocodigo.model.form.EstadoForm;
import br.com.zup.desafio.casadocodigo.model.form.PaisForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoForm estadoForm) {
        Estado estado = estadoForm.converter(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok(new EstadoDto(estado));
    }
}
